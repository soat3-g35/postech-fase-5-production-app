package br.com.fiap.pos.soat3.producao.infrastructure.integration.messaging.pagamentoconfirmado;


public class PagamentoConfirmadoMessage {

    private String pagamentoId;

    private String pedidoId;

    private String clienteId;

    private String valor;

    private String status;

    public PagamentoConfirmadoMessage() {
    }

    public PagamentoConfirmadoMessage(String pagamentoId, String pedidoId, String clienteId, String valor, String status) {
        this.pagamentoId = pagamentoId;
        this.pedidoId = pedidoId;
        this.clienteId = clienteId;
        this.valor = valor;
        this.status = status;
    }

    public String getPagamentoId() {
        return pagamentoId;
    }

    public void setPagamentoId(String pagamentoId) {
        this.pagamentoId = pagamentoId;
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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
