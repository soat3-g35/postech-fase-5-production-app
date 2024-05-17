package br.com.fiap.pos.soat3.producao.application.gateways;

import br.com.fiap.pos.soat3.producao.domain.entity.Pagamento;

public interface PagamentoGateway {
    Pagamento realizaPagamento(Pagamento pagamento);
}
