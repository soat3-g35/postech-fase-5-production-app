package br.com.fiap.pos.soat3.producao.application.usecases;

import br.com.fiap.pos.soat3.producao.application.gateways.ConsultaStatusPedidoGateway;
import br.com.fiap.pos.soat3.producao.application.gateways.ListaPedidoGateway;
import br.com.fiap.pos.soat3.producao.application.usecases.pedido.ConsultaStatusPedidoInteractor;
import br.com.fiap.pos.soat3.producao.application.usecases.pedido.ListaPedidosInteractor;
import br.com.fiap.pos.soat3.producao.domain.entity.Pedido;
import br.com.fiap.pos.soat3.producao.domain.entity.StatusPedido;
import br.com.fiap.pos.soat3.producao.infrastructure.controllers.pedido.PedidoResponse;
import br.com.fiap.pos.soat3.producao.infrastructure.gateways.pedido.PedidoMapper;
import org.checkerframework.checker.units.qual.A;
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
public class ListaStatusPedidoInteractorTest {

    @Mock
    private ListaPedidoGateway gateway;

    @Mock
    private PedidoMapper pedidoMapper;

    @InjectMocks
    ListaPedidosInteractor useCase;

    @Test
    void whenListaPedidos_shouldReturnCorrectStatus() {
        ArrayList list = new ArrayList<>();
        PedidoResponse response = new PedidoResponse(
                1l, 2l, new ArrayList<>(), "20", StatusPedido.GERADO
        );
        list.add(response);
        Pedido expected = new Pedido(1l, 2l, new ArrayList<>(), "20", StatusPedido.GERADO);
        when(pedidoMapper.toPedido(response)).thenReturn(expected);
        when(gateway.recuperaPedidos()).thenReturn(list);

        List<Pedido> current = useCase.listaPedidos();

        assertEquals("", 1, current.size());
        assertEquals("", expected, current.get(0));
    }
}
