package br.com.fiap.pos.soat3.producao.infrastructure.controllers.categoria;

import br.com.fiap.pos.soat3.producao.domain.entity.Categoria;

public class CategoriaDTOMapper {

    CategoriaResponse toResponse(Categoria categoria) {
        return new CategoriaResponse(categoria.getId(), categoria.getNome());
    }

    public Categoria toCategoria(CategoriaRequest request) {
        return new Categoria(request.nome());
    }
}
