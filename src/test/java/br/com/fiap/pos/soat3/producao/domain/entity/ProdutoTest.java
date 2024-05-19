package br.com.fiap.pos.soat3.producao.domain.entity;

import br.com.fiap.pos.soat3.producao.infrastructure.controllers.pedido.PedidoResponse;
import br.com.fiap.pos.soat3.producao.infrastructure.controllers.pedido.StatusPedidoResponse;
import br.com.fiap.pos.soat3.producao.infrastructure.integration.ListaPedido;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class ProdutoTest {

    @InjectMocks
    private Produto produto;

    @Test
    void givenProduto_shouldReturnProduto() {
        Produto produto = new Produto(1l,
                "nome",
                "descricao",
                "imagem",
                new BigDecimal(10),
                new Categoria(1l, "nome"));

        assertNotNull("", produto);
        assertEquals("", produto.getId(), 1l);
        assertEquals("", produto.getNome(), "nome");
        assertEquals("", produto.getDescricao(), "descricao");
        assertEquals("", produto.getImagem(), "imagem");
        assertEquals("", produto.getValor(), new BigDecimal(10));
        assertEquals("", produto.getCategoria().getNome(), "nome");

    }

    void givenProduto_shouldReturnProduto1() {
        Produto produto = new Produto("nome",
                "descricao",
                "imagem",
                new BigDecimal(10),
                new Categoria(1l, "nome"));

        assertNotNull("", produto);
        assertEquals("", produto.getId(), 1l);

    }

    @Test
    void givenProduto_shouldReturnEmptyProduto() {
        Produto produto = new Produto();
        produto.setId(1l);
        produto.setNome("nome");
        produto.setDescricao("descricao");
        produto.setImagem("image");
        produto.setValor(new BigDecimal(10));
        produto.setCategoria(new Categoria("nome"));

        assertNotNull("", produto);
    }
}
