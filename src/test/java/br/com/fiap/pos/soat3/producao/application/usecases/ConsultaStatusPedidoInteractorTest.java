package br.com.fiap.pos.soat3.producao.application.usecases;

import br.com.fiap.pos.soat3.producao.application.gateways.AtualizaStatusPedidoGateway;
import br.com.fiap.pos.soat3.producao.application.gateways.ConsultaStatusPedidoGateway;
import br.com.fiap.pos.soat3.producao.application.usecases.pedido.AtualizaStatusPedidoInteractor;
import br.com.fiap.pos.soat3.producao.application.usecases.pedido.ConsultaStatusPedidoInteractor;
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
public class ConsultaStatusPedidoInteractorTest {

    @Mock
    private ConsultaStatusPedidoGateway gateway;

    @InjectMocks
    ConsultaStatusPedidoInteractor useCase;

    @Test
    void givenCorrectData_whenConsultaStatusPedido_shouldReturnCorrectStatus() {
        when(gateway.consultaStatusPedido(1L)).thenReturn(
                StatusPedido.FINALIZADO.getStatus()
        );

        String current = useCase.consultaStatusPedido(1L);

        assertEquals("", "Finalizado", current);
    }
}
