package br.com.fiap.pos.soat3.lanchonete.infrastructure.integration;

import br.com.fiap.pos.soat3.lanchonete.application.gateways.ConsultaStatusPedidoGateway;
import org.springframework.stereotype.Component;

@Component
public class ConsultaStatusPedido implements ConsultaStatusPedidoGateway {

    private final PedidoCliente pedidoCliente;

    public ConsultaStatusPedido(PedidoCliente pedidoCliente) {
        this.pedidoCliente = pedidoCliente;
    }

    @Override
    public String consultaStatusPedido(Long pedidoId) {
        return pedidoCliente.consultaStatusPedido(pedidoId).getStatus();
    }
}
