package br.com.fiap.pos.soat3.lanchonete.infrastructure.config;

import br.com.fiap.pos.soat3.lanchonete.application.gateways.AtualizaStatusPedidoGateway;
import br.com.fiap.pos.soat3.lanchonete.application.gateways.ConsultaStatusPedidoGateway;
import br.com.fiap.pos.soat3.lanchonete.application.gateways.ListaPedidoGateway;
import br.com.fiap.pos.soat3.lanchonete.application.usecases.pedido.AtualizaStatusPedidoInteractor;
import br.com.fiap.pos.soat3.lanchonete.application.usecases.pedido.ConsultaStatusPedidoInteractor;
import br.com.fiap.pos.soat3.lanchonete.application.usecases.pedido.ListaPedidosInteractor;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.pedido.PedidoDTOMapper;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.gateways.pedido.PedidoMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PedidoBeanConfig {

    @Bean
    AtualizaStatusPedidoInteractor atualizaStatusPedidoUseCase(AtualizaStatusPedidoGateway atualizaStatusPedidoGateway, PedidoMapper pedidoMapper) {
        return new AtualizaStatusPedidoInteractor(atualizaStatusPedidoGateway, pedidoMapper);
    }

    @Bean
    PedidoDTOMapper pedidoDTOMapper() {
        return new PedidoDTOMapper();
    }

    @Bean
    AtualizaStatusPedidoInteractor atualizaStatusPedidoGateway(AtualizaStatusPedidoGateway atualizaStatusPedidoGateway, PedidoMapper pedidoMapper) {
        return new AtualizaStatusPedidoInteractor(atualizaStatusPedidoGateway, pedidoMapper);
    }

    @Bean
    ConsultaStatusPedidoInteractor consultaStatusPedidoUseCase(ConsultaStatusPedidoGateway consultaStatusPedidoGateway) {
        return new ConsultaStatusPedidoInteractor(consultaStatusPedidoGateway);
    }

    @Bean
    ListaPedidosInteractor listaPedidosUseCase(ListaPedidoGateway listaPedidoGateway, PedidoMapper pedidoMapper) {
        return new ListaPedidosInteractor(listaPedidoGateway, pedidoMapper);
    }

    @Bean
    PedidoMapper pedidoEntityMapper() {
        return new PedidoMapper();
    }
    
}
