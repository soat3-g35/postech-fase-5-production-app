package br.com.fiap.pos.soat3.lanchonete.application.gateways;

import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.pedido.PedidoResponse;


import java.util.List;

public interface ListaPedidoGateway {
    List<PedidoResponse> recuperaPedidos();
}
