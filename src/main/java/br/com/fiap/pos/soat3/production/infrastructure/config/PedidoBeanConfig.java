package br.com.fiap.pos.soat3.production.infrastructure.config;

import br.com.fiap.pos.soat3.production.application.gateways.PedidoGateway;
import br.com.fiap.pos.soat3.production.application.usecases.AtualizaStatusPedidoInteractor;
import br.com.fiap.pos.soat3.production.application.usecases.ConsultaStatusPedidoInteractor;
import br.com.fiap.pos.soat3.production.application.usecases.ListaPedidosInteractor;
import br.com.fiap.pos.soat3.production.infrastructure.controllers.PedidoDTOMapper;
import br.com.fiap.pos.soat3.production.infrastructure.gateways.PedidoEntityMapper;
import br.com.fiap.pos.soat3.production.infrastructure.gateways.PedidoRepositoryGateway;
import br.com.fiap.pos.soat3.production.infrastructure.persistence.itempedido.ItemPedidoRepository;
import br.com.fiap.pos.soat3.production.infrastructure.persistence.pedido.PedidoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PedidoBeanConfig {

    @Bean
    AtualizaStatusPedidoInteractor atualizaStatusPedidoUseCase(PedidoGateway pedidoGateway) {
        return new AtualizaStatusPedidoInteractor(pedidoGateway);
    }

    @Bean
    PedidoDTOMapper pedidoDTOMapper() {
        return new PedidoDTOMapper();
    }

    @Bean
    ConsultaStatusPedidoInteractor consultaStatusPedidoUseCase(PedidoGateway pedidoGateway) {
        return new ConsultaStatusPedidoInteractor(pedidoGateway);
    }

    @Bean
    ListaPedidosInteractor listaPedidosUseCase(PedidoGateway pedidoGateway) {
        return new ListaPedidosInteractor(pedidoGateway);
    }

    @Bean
    PedidoEntityMapper pedidoEntityMapper() {
        return new PedidoEntityMapper();
    }

    @Bean
    PedidoRepositoryGateway pedidoRepositoryGateway(PedidoRepository pedidoRepository,
                                                    ItemPedidoRepository itemPedidoRepository,
                                                    PedidoEntityMapper pedidoEntityMapper) {
        return new PedidoRepositoryGateway(pedidoRepository, itemPedidoRepository, pedidoEntityMapper);
    }
}
