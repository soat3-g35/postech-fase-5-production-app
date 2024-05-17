package br.com.fiap.pos.soat3.producao.application.usecases.pedido;

import br.com.fiap.pos.soat3.producao.application.gateways.PedidoGateway;
import br.com.fiap.pos.soat3.producao.domain.entity.Pedido;

public class AtualizaStatusPedidoInteractor {
    private final PedidoGateway pedidoGateway;

    public AtualizaStatusPedidoInteractor(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    public Pedido atualizaStatusPedido(Long pedidoId, String status) {
        return pedidoGateway.atualizaStatusPedido(pedidoId, status);
    }

}
