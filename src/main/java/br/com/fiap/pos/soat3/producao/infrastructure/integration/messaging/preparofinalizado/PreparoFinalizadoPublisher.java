package br.com.fiap.pos.soat3.producao.infrastructure.integration.messaging.preparofinalizado;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PreparoFinalizadoPublisher {

    private final Logger log = LoggerFactory.getLogger(PreparoFinalizadoPublisher.class);

    @Value("${aws.queueName.preparoFinalizado}")
    private String queueName;
    private final AmazonSQS amazonSQSClient;
    private final ObjectMapper objectMapper;

    public PreparoFinalizadoPublisher(AmazonSQS amazonSQSClient, ObjectMapper objectMapper) {
        this.amazonSQSClient = amazonSQSClient;
        this.objectMapper = objectMapper;
    }

    public void publishMessage(String pedidoId) {
        try {
            GetQueueUrlResult queueUrl = amazonSQSClient.getQueueUrl(queueName);
            objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

            log.info("SAGA 11: Publica preparo finalizado");
            amazonSQSClient.sendMessage(queueUrl.getQueueUrl(),
                    objectMapper.writeValueAsString(pedidoId));

            log.info("Queue Preparo Finalizado publicado: {}", pedidoId);
        } catch (Exception e) {
            log.error("Queue Exception Message: {}", e.getMessage());
        }
    }
}

