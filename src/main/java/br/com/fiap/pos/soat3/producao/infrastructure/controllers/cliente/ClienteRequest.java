package br.com.fiap.pos.soat3.producao.infrastructure.controllers.cliente;

public record ClienteRequest(Long id, String nome, String email, String CPF) {
}
