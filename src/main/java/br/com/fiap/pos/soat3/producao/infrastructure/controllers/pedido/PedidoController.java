package br.com.fiap.pos.soat3.producao.infrastructure.controllers.pedido;


import br.com.fiap.pos.soat3.producao.application.usecases.pedido.AtualizaStatusPedidoInteractor;
import br.com.fiap.pos.soat3.producao.application.usecases.pedido.ConsultaStatusPedidoInteractor;
import br.com.fiap.pos.soat3.producao.application.usecases.pedido.FinalizaPreparoInteractor;
import br.com.fiap.pos.soat3.producao.application.usecases.pedido.ListaPedidosInteractor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final ListaPedidosInteractor listaPedidosUseCase;
    private final AtualizaStatusPedidoInteractor atualizaStatusPedidoUseCase;
    private final FinalizaPreparoInteractor finalizaPreparoUseCase;
    private final ConsultaStatusPedidoInteractor consultaStatusPedidoUseCase;
    private final PedidoDTOMapper pedidoDTOMapper;

    public PedidoController(ListaPedidosInteractor listaPedidosUseCase,
                            AtualizaStatusPedidoInteractor atualizaStatusPedidoUseCase,
                            FinalizaPreparoInteractor finalizaPreparoUseCase,
                            ConsultaStatusPedidoInteractor consultaStatusPedidoUseCase,
                            PedidoDTOMapper pedidoDTOMapper) {
        this.listaPedidosUseCase = listaPedidosUseCase;
        this.atualizaStatusPedidoUseCase = atualizaStatusPedidoUseCase;
        this.finalizaPreparoUseCase = finalizaPreparoUseCase;
        this.consultaStatusPedidoUseCase = consultaStatusPedidoUseCase;
        this.pedidoDTOMapper = pedidoDTOMapper;
    }

    @GetMapping("/lista")
    public ResponseEntity<List<PedidoResponse>> listaPedidos() {
        return ResponseEntity.ok(pedidoDTOMapper.toPedidoResponseList(listaPedidosUseCase.listaPedidos()));
    }

    @GetMapping("/{pedidoId}/status")
    public ResponseEntity<StatusPedidoResponse> consultaStatusPedido(@PathVariable("pedidoId") Long pedidoId) {
        return new ResponseEntity<>(pedidoDTOMapper.toStatusPedidoResponse(consultaStatusPedidoUseCase.consultaStatusPedido(pedidoId)), HttpStatus.OK);
    }

    @PutMapping("/{pedidoId}/status/{status}")
    public ResponseEntity<PedidoResponse> atualizaStatusPedido(@PathVariable("pedidoId") Long pedidoId,
                                                               @PathVariable("status") String statusPedido) {
        return ResponseEntity.ok(pedidoDTOMapper.toPedidoResponse(atualizaStatusPedidoUseCase.atualizaStatusPedido(pedidoId, statusPedido)));
    }

    @PutMapping("/{pedidoId}/finalizado")
    public ResponseEntity<PedidoResponse> finalizaPreparo(@PathVariable("pedidoId") Long pedidoId) {
        finalizaPreparoUseCase.finalizaPreparo(pedidoId);
        return ResponseEntity.ok().build();
    }
}
