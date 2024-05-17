package br.com.fiap.pos.soat3.producao.infrastructure.integration;

import br.com.fiap.pos.soat3.producao.application.gateways.RealizaPagamentoMockGateway;
import org.springframework.stereotype.Component;

@Component
public class RealizaPagamentoMock implements RealizaPagamentoMockGateway {

    private final MVPCliente mVPCliente;

    public RealizaPagamentoMock(MVPCliente mVPCliente) {
        this.mVPCliente = mVPCliente;
    }

    @Override
    public MVPResponse realizaPagamentoMVP(Long pedidoId, Long pagamentoId) {
        return mVPCliente.realizaPagamentoMock(pedidoId, pagamentoId);
    }
}
