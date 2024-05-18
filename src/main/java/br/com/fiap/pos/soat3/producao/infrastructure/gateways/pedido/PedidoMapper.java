package br.com.fiap.pos.soat3.producao.infrastructure.gateways.pedido;

import br.com.fiap.pos.soat3.producao.domain.entity.ItemPedido;
import br.com.fiap.pos.soat3.producao.domain.entity.Pedido;
import br.com.fiap.pos.soat3.producao.infrastructure.controllers.pedido.PedidoResponse;

public class PedidoMapper {
    public Pedido toPedido(PedidoResponse pedidoResponse) {
        return new Pedido(pedidoResponse.getId(),
                pedidoResponse.getClienteId(),
                pedidoResponse.getItensPedido().stream().map(item ->
                        new ItemPedido(
                                item.produto(),
                                item.quantidade()
                        )
                ).toList(),

                pedidoResponse.getTotalPedido(),
                pedidoResponse.getStatus());
    }
}
