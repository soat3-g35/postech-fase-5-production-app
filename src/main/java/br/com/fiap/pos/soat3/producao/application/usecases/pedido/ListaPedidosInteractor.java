package br.com.fiap.pos.soat3.lanchonete.application.usecases.pedido;

import br.com.fiap.pos.soat3.lanchonete.application.gateways.ListaPedidoGateway;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.Pedido;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.pedido.PedidoResponse;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.gateways.pedido.PedidoMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ListaPedidosInteractor {
    
    private final ListaPedidoGateway listaPedidoGateway;
    private final PedidoMapper pedidoMapper;

    public ListaPedidosInteractor(ListaPedidoGateway listaPedidoGateway, PedidoMapper pedidoMapper) {
        this.listaPedidoGateway = listaPedidoGateway;
        this.pedidoMapper = pedidoMapper;
    }

    public List<Pedido> listaPedidos() {
        List<PedidoResponse> listaPedidos = listaPedidoGateway.recuperaPedidos();
        assert listaPedidos != null;
        return listaPedidos.stream().map(pedidoMapper::toPedido)
                .collect(Collectors.toList());
    }
}
