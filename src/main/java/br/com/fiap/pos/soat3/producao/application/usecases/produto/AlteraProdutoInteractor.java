package br.com.fiap.pos.soat3.producao.application.usecases.produto;

import br.com.fiap.pos.soat3.producao.application.gateways.ProdutoGateway;
import br.com.fiap.pos.soat3.producao.domain.entity.Produto;

public class AlteraProdutoInteractor {
    private final ProdutoGateway produtoGateway;

    public AlteraProdutoInteractor(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    public Produto alteraProduto(Produto produto) {
        return produtoGateway.alteraProduto(produto);
    }
}
