package br.com.fiap.pos.soat3.producao.infrastructure.integration;

import br.com.fiap.pos.soat3.producao.application.gateways.AtualizaStatusPedidoGateway;
import br.com.fiap.pos.soat3.producao.infrastructure.controllers.pedido.PedidoResponse;
import org.springframework.stereotype.Component;

@Component
public class AtualizaStatusPedido implements AtualizaStatusPedidoGateway {

    private final PedidoCliente pedidoCliente;

    public AtualizaStatusPedido(PedidoCliente pedidoCliente) {
        this.pedidoCliente = pedidoCliente;
    }


    @Override
    public PedidoResponse atualizaStatusPedido(Long pedidoId, String statusPedido) {
        return pedidoCliente.atualizaStatusPedido(pedidoId, statusPedido);
    }
}
