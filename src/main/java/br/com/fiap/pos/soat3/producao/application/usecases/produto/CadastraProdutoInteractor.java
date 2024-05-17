package br.com.fiap.pos.soat3.producao.application.usecases.produto;

import br.com.fiap.pos.soat3.producao.application.gateways.ProdutoGateway;
import br.com.fiap.pos.soat3.producao.domain.entity.Produto;

public class CadastraProdutoInteractor {
    private final ProdutoGateway produtoGateway;


    public CadastraProdutoInteractor(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    public Produto cadastraProduto(Produto produto) {
        return produtoGateway.cadastraProduto(produto);
    }
}
