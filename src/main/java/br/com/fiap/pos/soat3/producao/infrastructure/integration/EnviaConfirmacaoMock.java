package br.com.fiap.pos.soat3.producao.infrastructure.integration;

import br.com.fiap.pos.soat3.producao.application.gateways.EnviaConfirmacaoGateway;
import br.com.fiap.pos.soat3.producao.infrastructure.controllers.pagamento.ConfirmacaoResponse;

public class EnviaConfirmacaoMock implements EnviaConfirmacaoGateway {

    private final MVPCliente mVPCliente;

    public EnviaConfirmacaoMock(MVPCliente mVPCliente) {
        this.mVPCliente = mVPCliente;
    }

    @Override
    public ConfirmacaoResponse enviaConfirmacaoMVP(Long pagamentoId) {
        return mVPCliente.verificaPagamentoMock(pagamentoId).getBody();
    }
}
