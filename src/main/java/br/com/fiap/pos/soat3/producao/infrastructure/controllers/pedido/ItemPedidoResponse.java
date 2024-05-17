package br.com.fiap.pos.soat3.producao.infrastructure.controllers.pedido;

import br.com.fiap.pos.soat3.producao.domain.entity.Produto;

public record ItemPedidoResponse(Produto produto, int quantidade) {
}
