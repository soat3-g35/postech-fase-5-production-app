package br.com.fiap.pos.soat3.producao.infrastructure.integration.messaging.pagamentoconfirmado;

import br.com.fiap.pos.soat3.producao.infrastructure.integration.messaging.iniciapreparo.IniciaPreparoPublisher;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PagamentoConfirmadoConsumer {

    private final Logger log = LoggerFactory.getLogger(PagamentoConfirmadoConsumer.class);

    @Value("${aws.queueName.pagamentoConfirmado}")
    private String queueName;

    @Autowired
    private final AmazonSQS amazonSQSClient;

    @Autowired
    private final ObjectMapper objectMapper;

    @Autowired
    private final IniciaPreparoPublisher iniciaPreparoPublisher;

    public PagamentoConfirmadoConsumer(AmazonSQS amazonSQSClient, ObjectMapper objectMapper, IniciaPreparoPublisher iniciaPreparoPublisher) {
        this.amazonSQSClient = amazonSQSClient;
        this.objectMapper = objectMapper;
        this.iniciaPreparoPublisher = iniciaPreparoPublisher;
    }

    @Scheduled(fixedDelay = 500)// It runs every 5 seconds.
    @Transactional
    public void consumeMessages() {

        try {
            String queueUrl = amazonSQSClient.getQueueUrl(queueName).getQueueUrl();

            ReceiveMessageResult receiveMessageResult = amazonSQSClient.receiveMessage(queueUrl);

            if (!receiveMessageResult.getMessages().isEmpty()) {
                log.info("SAGA 7: Consome pagamento confirmado");
                com.amazonaws.services.sqs.model.Message message = receiveMessageResult.getMessages().get(0);
                log.info("Pagamento: Read Message from queue: {}", message.getBody());
                PagamentoConfirmadoMessage pagamentoConfirmado = objectMapper.readValue(message.getBody(), PagamentoConfirmadoMessage.class);
                log.info("SAGA 8: Publica inicia preparo");
                iniciaPreparoPublisher.publishMessage(pagamentoConfirmado.getPedidoId());
                amazonSQSClient.deleteMessage(queueUrl, message.getReceiptHandle());
            }

        } catch (Exception e) {
            log.error("Queue Exception Message: {}", e.getMessage());
        }
    }
}
