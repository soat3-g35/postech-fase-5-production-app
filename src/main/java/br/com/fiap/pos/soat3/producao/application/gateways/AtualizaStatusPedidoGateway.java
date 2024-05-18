package br.com.fiap.pos.soat3.lanchonete.application.gateways;

import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.pedido.PedidoResponse;

public interface AtualizaStatusPedidoGateway {
    
    PedidoResponse atualizaStatusPedido(Long pedidoId, String statusPedido);
}
