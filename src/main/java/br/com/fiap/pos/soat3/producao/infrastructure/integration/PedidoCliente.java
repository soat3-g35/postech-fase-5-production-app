package br.com.fiap.pos.soat3.producao.infrastructure.integration;

import br.com.fiap.pos.soat3.producao.infrastructure.controllers.pedido.PedidoResponse;
import br.com.fiap.pos.soat3.producao.infrastructure.controllers.pedido.StatusPedidoResponse;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Component
@FeignClient(name = "pedido-client", url = "${pedido-client.url}")
@Headers({"Content-Type: application/json", "Accept: application/json"})
public interface PedidoCliente {
    
    @GetMapping("/pedidos/lista/producao")
    List<PedidoResponse> listaPedidos();

    @GetMapping("/pedidos/{pedidoId}/status")
    StatusPedidoResponse consultaStatusPedido(@PathVariable("pedidoId") Long pedidoId);

    @PutMapping("/pedidos/{pedidoId}/status/{status}")
    PedidoResponse atualizaStatusPedido(@PathVariable("pedidoId") Long pedidoId,
                                                        @PathVariable("status") String statusPedido);
}
