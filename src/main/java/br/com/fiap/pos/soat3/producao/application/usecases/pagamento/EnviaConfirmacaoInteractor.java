package br.com.fiap.pos.soat3.producao.application.usecases.pagamento;

import br.com.fiap.pos.soat3.producao.application.gateways.EnviaConfirmacaoGateway;
import br.com.fiap.pos.soat3.producao.application.gateways.PedidoGateway;
import br.com.fiap.pos.soat3.producao.infrastructure.controllers.pagamento.ConfirmacaoResponse;

public class EnviaConfirmacaoInteractor {

    private final EnviaConfirmacaoGateway enviaConfirmacaoGateway;
    private final PedidoGateway pedidoGateway;

    public EnviaConfirmacaoInteractor(EnviaConfirmacaoGateway enviaConfirmacaoGateway, PedidoGateway pedidoGateway) {
        this.enviaConfirmacaoGateway = enviaConfirmacaoGateway;
        this.pedidoGateway = pedidoGateway;
    }

    public void enviaConfirmacao(Long pedidoId, Long pagamentoId) {
        ConfirmacaoResponse response = enviaConfirmacaoGateway.enviaConfirmacaoMVP(pagamentoId);
        pedidoGateway.atualizaStatusPedido(pedidoId, response.getResultado());
    }
}
