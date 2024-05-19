package br.com.fiap.pos.soat3.producao.domain.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class PedidoTest {

    @Test
    void givenPedido_shouldReturnPedido() {
        Produto produto = new Produto(1l);
        ItemPedido item1 = new ItemPedido(produto, 1);
        List<ItemPedido> list = Arrays.asList(item1);
        Pedido pedido = new Pedido(1l,
                1l, list, "10", StatusPedido.PRONTO);

        assertNotNull("", pedido);
        assertEquals("", pedido.getId(), 1l);
        assertEquals("", produto.getNome(), "nome");
        assertEquals("", produto.getDescricao(), "descricao");
        assertEquals("", produto.getImagem(), "imagem");
        assertEquals("", produto.getValor(), new BigDecimal(10));
        assertEquals("", produto.getCategoria().getNome(), "nome");

    }

    @Test
    void givenPedido_shouldReturnPedido2() {
        Produto produto = new Produto(1l);
        ItemPedido item1 = new ItemPedido(produto, 1);
        List<ItemPedido> list = Arrays.asList(item1);
        Pedido pedido = new Pedido();
        pedido.setId(1l);
        pedido.setTotalPedido("10");
        pedido.setClienteId(1l);
        pedido.setItensPedido(list);
        pedido.setStatus(StatusPedido.PRONTO);
        LocalDateTime date = LocalDateTime.now();
        pedido.setDataDeCriacao(date);

        assertNotNull("", pedido);
        assertEquals("", pedido.getId(), 1l);
        assertEquals("", pedido.getTotalPedido(), "10");
        assertEquals("", pedido.getClienteId(), 1l);
        assertEquals("", pedido.getStatus(), StatusPedido.PRONTO);
        assertEquals("", pedido.getItensPedido().get(0).getQuantidade(), 1);
        assertEquals("", pedido.getDataDeCriacao(), date);

    }
}
