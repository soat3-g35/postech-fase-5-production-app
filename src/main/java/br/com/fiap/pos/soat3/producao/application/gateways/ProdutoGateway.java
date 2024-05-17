package br.com.fiap.pos.soat3.producao.application.gateways;

import br.com.fiap.pos.soat3.producao.domain.entity.Produto;

import java.util.List;

public interface ProdutoGateway {
    List<Produto> buscaPorCategoria(Long id);

    Produto buscaProduto(Long id);

    Produto cadastraProduto(Produto produto);

    Produto alteraProduto(Produto produto);

    void deletaProduto(Long id);
}
