package br.com.fiap.pos.soat3.producao.application.usecases.cliente;

import br.com.fiap.pos.soat3.producao.application.gateways.ClienteGateway;
import br.com.fiap.pos.soat3.producao.domain.entity.Cliente;

public class BuscaClientePorCPFInteractor {
    private final ClienteGateway clienteGateway;

    public BuscaClientePorCPFInteractor(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public Cliente bucaClientePorCPF(String cpf) {
        return clienteGateway.buscaClientePorCPF(cpf);
    }
}
