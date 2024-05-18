package br.com.fiap.pos.soat3.producao.application.usecases.pedido;

import br.com.fiap.pos.soat3.producao.application.gateways.ConsultaStatusPedidoGateway;


public class ConsultaStatusPedidoInteractor {
    private final ConsultaStatusPedidoGateway consultaStatusPedidoGateway;

    public ConsultaStatusPedidoInteractor(ConsultaStatusPedidoGateway consultaStatusPedidoGateway) {
        this.consultaStatusPedidoGateway = consultaStatusPedidoGateway;
    }

    public String consultaStatusPedido(Long pedidoId) {
        return consultaStatusPedidoGateway.consultaStatusPedido(pedidoId);
    }
}
