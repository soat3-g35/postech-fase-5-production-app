package br.com.fiap.pos.soat3.production.application.usecases;

import br.com.fiap.pos.soat3.production.application.gateways.PedidoGateway;
import br.com.fiap.pos.soat3.production.domain.entity.Pedido;

public class AtualizaStatusPedidoInteractor {
    private final PedidoGateway pedidoGateway;

    public AtualizaStatusPedidoInteractor(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    public Pedido atualizaStatusPedido(Long pedidoId, String status) {
        return pedidoGateway.atualizaStatusPedido(pedidoId, status);
    }

}
