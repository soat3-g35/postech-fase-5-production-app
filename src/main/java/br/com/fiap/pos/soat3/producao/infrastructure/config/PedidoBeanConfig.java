package br.com.fiap.pos.soat3.producao.infrastructure.config;

import br.com.fiap.pos.soat3.producao.application.gateways.AtualizaStatusPedidoGateway;
import br.com.fiap.pos.soat3.producao.application.gateways.ConsultaStatusPedidoGateway;
import br.com.fiap.pos.soat3.producao.application.gateways.FinalizaPreparoGateway;
import br.com.fiap.pos.soat3.producao.application.gateways.ListaPedidoGateway;
import br.com.fiap.pos.soat3.producao.application.usecases.pedido.AtualizaStatusPedidoInteractor;
import br.com.fiap.pos.soat3.producao.application.usecases.pedido.ConsultaStatusPedidoInteractor;
import br.com.fiap.pos.soat3.producao.application.usecases.pedido.FinalizaPreparoInteractor;
import br.com.fiap.pos.soat3.producao.application.usecases.pedido.ListaPedidosInteractor;
import br.com.fiap.pos.soat3.producao.infrastructure.controllers.pedido.PedidoDTOMapper;
import br.com.fiap.pos.soat3.producao.infrastructure.gateways.pedido.PedidoMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PedidoBeanConfig {

    @Bean
    FinalizaPreparoInteractor finalizaPreparoUseCase(FinalizaPreparoGateway finalizaPreparoGateway) {
        return new FinalizaPreparoInteractor(finalizaPreparoGateway);
    }

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
