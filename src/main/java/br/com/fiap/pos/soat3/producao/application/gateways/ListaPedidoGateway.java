package br.com.fiap.pos.soat3.producao.application.gateways;

import br.com.fiap.pos.soat3.producao.infrastructure.controllers.pedido.PedidoResponse;


import java.util.List;

public interface ListaPedidoGateway {
    List<PedidoResponse> recuperaPedidos();
}
