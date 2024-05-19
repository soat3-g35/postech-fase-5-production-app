package br.com.fiap.pos.soat3.producao.infrastructure.controller;

import br.com.fiap.pos.soat3.producao.domain.entity.ItemPedido;
import br.com.fiap.pos.soat3.producao.domain.entity.Pedido;
import br.com.fiap.pos.soat3.producao.domain.entity.Produto;
import br.com.fiap.pos.soat3.producao.domain.entity.StatusPedido;
import br.com.fiap.pos.soat3.producao.infrastructure.controllers.pedido.ItemPedidoResponse;
import br.com.fiap.pos.soat3.producao.infrastructure.controllers.pedido.PedidoDTOMapper;
import br.com.fiap.pos.soat3.producao.infrastructure.controllers.pedido.PedidoResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PedidoDTOMapperTest {

    private PedidoDTOMapper mapper = new PedidoDTOMapper();


    @Test
    void givenModel_whenMapper_shouldReturnResponse() {
        Produto produto = new Produto(1l);
        ItemPedido item1 = new ItemPedido(produto, 1);
        List<ItemPedido> list = Arrays.asList(item1);
        Pedido pedido = new Pedido(1l,
                1l, list, "10", StatusPedido.PRONTO);

        ItemPedidoResponse itemPedidoResponse = new ItemPedidoResponse(produto, 1);
        List<ItemPedidoResponse> listItem = Arrays.asList(itemPedidoResponse);
        PedidoResponse expected = new PedidoResponse(1l,1l,listItem,"10", StatusPedido.PRONTO);



        PedidoResponse result = mapper.toPedidoResponse(pedido);

        assertEquals(expected.getId(), result.getId());
    }

    @Test
    void givenModel_whenMapper_shouldReturnListResponse() {
        Produto produto = new Produto(1l);
        ItemPedido item1 = new ItemPedido(produto, 1);
        List<ItemPedido> list = Arrays.asList(item1);
        Pedido pedido = new Pedido(1l,
                1l, list, "10", StatusPedido.PRONTO);
        List<Pedido> listPedidos = Arrays.asList(pedido);

        ItemPedidoResponse itemPedidoResponse = new ItemPedidoResponse(produto, 1);
        List<ItemPedidoResponse> listItem = Arrays.asList(itemPedidoResponse);
        PedidoResponse expected = new PedidoResponse(1l,1l,listItem,"10", StatusPedido.PRONTO);



        List<PedidoResponse> result = mapper.toPedidoResponseList(listPedidos);

        assertEquals(expected.getId(), result.get(0).getId());
    }

}
