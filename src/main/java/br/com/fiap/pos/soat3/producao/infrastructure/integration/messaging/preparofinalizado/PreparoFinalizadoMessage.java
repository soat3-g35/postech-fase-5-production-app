package br.com.fiap.pos.soat3.producao.infrastructure.integration.messaging.preparofinalizado;

public class PreparoFinalizadoMessage {

    private String pedidoId;
    private String clienteId;

    public PreparoFinalizadoMessage(String pedidoId, String clienteId) {
        this.pedidoId = pedidoId;
        this.clienteId = clienteId;
    }

    public String getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(String pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }
}
