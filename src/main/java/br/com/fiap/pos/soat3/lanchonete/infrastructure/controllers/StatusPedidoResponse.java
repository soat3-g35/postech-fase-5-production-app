package br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers;

public class StatusPedidoResponse {

    private String status;

    public StatusPedidoResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
