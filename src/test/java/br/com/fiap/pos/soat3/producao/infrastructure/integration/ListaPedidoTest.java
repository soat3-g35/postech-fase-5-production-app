package br.com.fiap.pos.soat3.producao.infrastructure.integration;


import br.com.fiap.pos.soat3.producao.domain.entity.StatusPedido;
import br.com.fiap.pos.soat3.producao.infrastructure.controllers.pedido.PedidoResponse;
import br.com.fiap.pos.soat3.producao.infrastructure.controllers.pedido.StatusPedidoResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ListaPedidoTest {

    @Mock
    private PedidoCliente pedidoCliente;

    @InjectMocks
    private ListaPedido listaPedido;

    @Test
    void givenListaPedidos_shouldReturnCorrectList() {
        List<PedidoResponse> list= new ArrayList<>();
        PedidoResponse response = new PedidoResponse(
                1l, 2l, new ArrayList<>(), "20", StatusPedido.AGUARDANDO_PAGAMENTO
        );
        list.add(response);

        when(pedidoCliente.listaPedidos()).thenReturn(list);

        List<PedidoResponse> current = listaPedido.recuperaPedidos();

        assertEquals("", list, current);
    }
}
