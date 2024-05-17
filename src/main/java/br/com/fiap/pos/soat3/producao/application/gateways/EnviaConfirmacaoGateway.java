package br.com.fiap.pos.soat3.producao.application.gateways;

import br.com.fiap.pos.soat3.producao.infrastructure.controllers.pagamento.ConfirmacaoResponse;

public interface EnviaConfirmacaoGateway {
    ConfirmacaoResponse enviaConfirmacaoMVP(Long pagamentoId);
}
