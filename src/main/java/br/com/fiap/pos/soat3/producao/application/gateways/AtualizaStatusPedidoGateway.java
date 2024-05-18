package br.com.fiap.pos.soat3.producao.application.gateways;

import br.com.fiap.pos.soat3.producao.infrastructure.controllers.pedido.PedidoResponse;

public interface AtualizaStatusPedidoGateway {
    
    PedidoResponse atualizaStatusPedido(Long pedidoId, String statusPedido);
}
