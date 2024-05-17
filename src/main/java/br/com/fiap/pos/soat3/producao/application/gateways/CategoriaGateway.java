package br.com.fiap.pos.soat3.producao.application.gateways;

import br.com.fiap.pos.soat3.producao.domain.entity.Categoria;

public interface CategoriaGateway {
    Categoria cadastraCategoria(Categoria categoria);

    Categoria buscaCategoria(Long id);
}
