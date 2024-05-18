package br.com.fiap.pos.soat3.producao.application.usecases;

import br.com.fiap.pos.soat3.producao.application.gateways.AtualizaStatusPedidoGateway;
import br.com.fiap.pos.soat3.producao.application.usecases.pedido.AtualizaStatusPedidoInteractor;
import br.com.fiap.pos.soat3.producao.domain.entity.Pedido;
import br.com.fiap.pos.soat3.producao.domain.entity.StatusPedido;
import br.com.fiap.pos.soat3.producao.infrastructure.controllers.pedido.PedidoResponse;
import br.com.fiap.pos.soat3.producao.infrastructure.gateways.pedido.PedidoMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AtualizaStatusPedidoInteractorTest {

    @Mock
    private PedidoMapper pedidoMapper;

    @Mock
    private AtualizaStatusPedidoGateway atualizaStatusPedidoGateway;

    @InjectMocks
    AtualizaStatusPedidoInteractor useCase;

    @Test
    void givenCorrectData_whenAtualizaStatusPedido_shouldReturnPedido() {
        Pedido expected = new Pedido(1l, new ArrayList<>());
        PedidoResponse response = new PedidoResponse(
                1l, 1l, new ArrayList<>(), "20", StatusPedido.RECUSADO
        );
        when(pedidoMapper.toPedido(response)).thenReturn(expected);
        when(atualizaStatusPedidoGateway.atualizaStatusPedido(1L, StatusPedido.RECUSADO.getStatus())).thenReturn(
                response
        );

        Pedido current = useCase.atualizaStatusPedido(1L, StatusPedido.RECUSADO.getStatus());

        assertEquals("", expected, current);
    }
}
