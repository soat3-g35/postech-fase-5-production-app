package br.com.fiap.pos.soat3.producao.application.usecases.pedido;

import br.com.fiap.pos.soat3.producao.application.gateways.PedidoGateway;

public class ConsultaStatusPedidoInteractor {
    private final PedidoGateway pedidoGateway;

    public ConsultaStatusPedidoInteractor(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    public String consultaStatusPedido(Long pedidoId) {
        return pedidoGateway.consultaStatusPedido(pedidoId);
    }
}
