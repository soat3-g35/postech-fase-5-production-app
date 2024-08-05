package br.com.fiap.pos.soat3.producao.application.usecases.pedido;

import br.com.fiap.pos.soat3.producao.application.gateways.FinalizaPreparoGateway;

public class FinalizaPreparoInteractor {
    private final FinalizaPreparoGateway finalizaPreparoGateway;

    public FinalizaPreparoInteractor(FinalizaPreparoGateway finalizaPreparoGateway) {
        this.finalizaPreparoGateway = finalizaPreparoGateway;
    }

    public void finalizaPreparo(Long pedidoId) {
        finalizaPreparoGateway.finalizaPreparo(pedidoId);
    }

}
