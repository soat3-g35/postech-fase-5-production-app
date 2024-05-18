package br.com.fiap.pos.soat3.producao.infrastructure.integration;

import br.com.fiap.pos.soat3.producao.application.gateways.ListaPedidoGateway;
import br.com.fiap.pos.soat3.producao.infrastructure.controllers.pedido.PedidoResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListaPedido implements ListaPedidoGateway {
    
    private final PedidoCliente pedidoCliente;


    public ListaPedido(PedidoCliente pedidoCliente) {
        this.pedidoCliente = pedidoCliente;
    }
    
    @Override
    public List<PedidoResponse> recuperaPedidos(){
        return this.pedidoCliente.listaPedidos();
    }
}
