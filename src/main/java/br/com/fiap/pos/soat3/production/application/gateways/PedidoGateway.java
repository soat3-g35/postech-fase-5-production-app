package br.com.fiap.pos.soat3.production.application.gateways;

import br.com.fiap.pos.soat3.production.domain.entity.Pedido;

import java.util.List;

public interface PedidoGateway {

    List<Pedido> listaPedidos();

    String consultaStatusPedido(Long pedidoId);

    Pedido atualizaStatusPedido(Long pedidoId, String statusPedido);

}
