package br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.pedido;

import br.com.fiap.pos.soat3.lanchonete.domain.entity.Pedido;

import java.util.ArrayList;
import java.util.List;

public class PedidoDTOMapper {
    public PedidoResponse toPedidoResponse(Pedido pedido) {
        return new PedidoResponse(pedido.getId(), pedido.getClienteId(),
                pedido.getItensPedido().stream().map(item ->
                        new ItemPedidoResponse(
                                item.getProduto(),
                                item.getQuantidade()
                        )
                ).toList(),
                pedido.getTotalPedido(), pedido.getStatus());
    }

    public List<PedidoResponse> toPedidoResponseList(List<Pedido> pedidos) {
        var lista = new ArrayList<PedidoResponse>();

        pedidos.forEach(pedido ->
                lista.add(
                        new PedidoResponse(
                                pedido.getId(),
                                pedido.getClienteId(),
                                pedido.getItensPedido().stream().map(item ->
                                        new ItemPedidoResponse(
                                                item.getProduto(),
                                                item.getQuantidade()
                                        )
                                ).toList(),
                                pedido.getTotalPedido(),
                                pedido.getStatus()
                        )
                )
        );

        return lista;
    }

    public StatusPedidoResponse toStatusPedidoResponse(String status) {
        return new StatusPedidoResponse(status);
    }
}
