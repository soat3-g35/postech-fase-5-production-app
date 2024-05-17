package br.com.fiap.pos.soat3.producao.infrastructure.gateways.categoria;

import br.com.fiap.pos.soat3.producao.domain.entity.Categoria;
import br.com.fiap.pos.soat3.producao.infrastructure.persistence.categoria.CategoriaEntity;

public class CategoriaEntityMapper {
    CategoriaEntity toEntity(Categoria categoriaDomainObj) {

        return new CategoriaEntity(categoriaDomainObj.getNome());
    }

    Categoria toDomainObj(CategoriaEntity categoriaEntity) {
        return new Categoria(categoriaEntity.getId(), categoriaEntity.getNome());
    }
}
