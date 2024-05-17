package br.com.fiap.pos.soat3.producao.infrastructure.controllers.pedido;

public record ItemPedidoRequest(Long produtoId, int quantidade) {
}
