package br.com.fiap.pos.soat3.producao.infrastructure.gateways.pedido;


import br.com.fiap.pos.soat3.producao.domain.entity.Pedido;
import br.com.fiap.pos.soat3.producao.domain.entity.StatusPedido;
import br.com.fiap.pos.soat3.producao.infrastructure.controllers.pedido.PedidoResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PedidoMapperTest {

    @InjectMocks
    PedidoMapper pedidoMapper;

    @Test
    void givenResponse_whenMapperToPedido_shouldReturnPedido() {
        PedidoResponse response = new PedidoResponse(
                1l, 2l, new ArrayList<>(), "20", StatusPedido.RECUSADO
        );

        Pedido expected = new Pedido(
                1l, 2l, new ArrayList<>(), "20", StatusPedido.RECUSADO
        );

        Pedido current = pedidoMapper.toPedido(response);

        assertEquals("error", expected.getId(), current.getId());
        assertEquals("error", expected.getClienteId(), current.getClienteId());
    }
}
