package br.com.fiap.pos.soat3.producao.application.usecases.categoria;

import br.com.fiap.pos.soat3.producao.application.gateways.CategoriaGateway;
import br.com.fiap.pos.soat3.producao.domain.entity.Categoria;

public class CadastraCategoriaInteractor {
    private final CategoriaGateway categoriaGateway;

    public CadastraCategoriaInteractor(CategoriaGateway categoriaGateway) {
        this.categoriaGateway = categoriaGateway;
    }

    public Categoria cadastraCategoria(Categoria categoria) {
        return categoriaGateway.cadastraCategoria(categoria);
    }
}
