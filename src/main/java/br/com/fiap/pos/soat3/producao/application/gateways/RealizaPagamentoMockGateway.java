package br.com.fiap.pos.soat3.producao.application.gateways;

import br.com.fiap.pos.soat3.producao.infrastructure.integration.MVPResponse;

public interface RealizaPagamentoMockGateway {

    MVPResponse realizaPagamentoMVP(Long pedidoId, Long pagamentoId);
}
