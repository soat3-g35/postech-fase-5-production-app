package br.com.fiap.pos.soat3.producao.application.usecases.pedido;

import br.com.fiap.pos.soat3.producao.application.gateways.AtualizaStatusPedidoGateway;
import br.com.fiap.pos.soat3.producao.domain.entity.Pedido;
import br.com.fiap.pos.soat3.producao.infrastructure.gateways.pedido.PedidoMapper;

public class AtualizaStatusPedidoInteractor {
    private final AtualizaStatusPedidoGateway atualizaStatusPedidoGateway;
    
    private final PedidoMapper pedidoMapper;

    public AtualizaStatusPedidoInteractor(AtualizaStatusPedidoGateway atualizaStatusPedidoGateway, PedidoMapper pedidoMapper) {
        this.atualizaStatusPedidoGateway = atualizaStatusPedidoGateway;
        this.pedidoMapper = pedidoMapper;
    }

    public Pedido atualizaStatusPedido(Long pedidoId, String status) {
        return pedidoMapper.toPedido(atualizaStatusPedidoGateway.atualizaStatusPedido(pedidoId, status));
    }

}
