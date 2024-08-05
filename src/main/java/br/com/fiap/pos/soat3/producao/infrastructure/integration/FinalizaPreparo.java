package br.com.fiap.pos.soat3.producao.infrastructure.integration;

import br.com.fiap.pos.soat3.producao.application.gateways.FinalizaPreparoGateway;
import br.com.fiap.pos.soat3.producao.infrastructure.integration.messaging.preparofinalizado.PreparoFinalizadoPublisher;
import org.springframework.stereotype.Component;

@Component
public class FinalizaPreparo implements FinalizaPreparoGateway {

    private final PreparoFinalizadoPublisher preparoFinalizadoPublisher;

    public FinalizaPreparo(PreparoFinalizadoPublisher preparoFinalizadoPublisher) {
        this.preparoFinalizadoPublisher = preparoFinalizadoPublisher;
    }

    @Override
    public void finalizaPreparo(Long pedidoId) {
        preparoFinalizadoPublisher.publishMessage(String.valueOf(pedidoId));
    }
}
