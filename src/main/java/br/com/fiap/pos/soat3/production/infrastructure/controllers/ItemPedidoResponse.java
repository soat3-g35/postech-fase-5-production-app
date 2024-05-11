package br.com.fiap.pos.soat3.production.infrastructure.controllers;

import br.com.fiap.pos.soat3.production.domain.entity.Produto;

public record ItemPedidoResponse(Produto produto, int quantidade) {
}
