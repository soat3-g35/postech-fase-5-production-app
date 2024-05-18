package br.com.fiap.pos.soat3.producao.infrastructure.integration;


import br.com.fiap.pos.soat3.producao.domain.entity.StatusPedido;
import br.com.fiap.pos.soat3.producao.infrastructure.controllers.pedido.PedidoResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AtualizaStatusPedidoTest {

    @Mock
    private PedidoCliente pedidoCliente;

    @InjectMocks
    private AtualizaStatusPedido statusPedido;

    @Test
    void givenAtualizaStatusPedido_shouldReturnPedidoResponse() {
        PedidoResponse response = new PedidoResponse(
                1l, 2l, new ArrayList<>(), "20", StatusPedido.AGUARDANDO_PAGAMENTO
        );
        when(pedidoCliente.atualizaStatusPedido(1l, StatusPedido.AGUARDANDO_PAGAMENTO.getStatus()))
                .thenReturn(
                        response
                );

        PedidoResponse current = statusPedido.atualizaStatusPedido(1l, StatusPedido.AGUARDANDO_PAGAMENTO.getStatus());

        assertEquals("", response, current);
    }
}
