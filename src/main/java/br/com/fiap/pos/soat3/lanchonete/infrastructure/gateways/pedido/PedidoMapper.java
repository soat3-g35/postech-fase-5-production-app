package br.com.fiap.pos.soat3.lanchonete.infrastructure.gateways.pedido;

import br.com.fiap.pos.soat3.lanchonete.domain.entity.ItemPedido;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.Pedido;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.Produto;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.pedido.ItemPedidoResponse;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.pedido.PedidoResponse;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.pedido.StatusPedidoResponse;

import java.util.ArrayList;
import java.util.List;

public class PedidoMapper {
    
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
