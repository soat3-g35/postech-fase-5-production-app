package br.com.fiap.pos.soat3.producao.infrastructure.config;

import br.com.fiap.pos.soat3.producao.application.gateways.CategoriaGateway;
import br.com.fiap.pos.soat3.producao.application.usecases.categoria.CadastraCategoriaInteractor;
import br.com.fiap.pos.soat3.producao.infrastructure.controllers.categoria.CategoriaDTOMapper;
import br.com.fiap.pos.soat3.producao.infrastructure.gateways.categoria.CategoriaEntityMapper;
import br.com.fiap.pos.soat3.producao.infrastructure.gateways.categoria.CategoriaRepositoryGateway;
import br.com.fiap.pos.soat3.producao.infrastructure.persistence.categoria.CategoriaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoriaBeanConfig {

    @Bean
    CategoriaEntityMapper categoriaEntityMapper() {
        return new CategoriaEntityMapper();
    }

    @Bean
    CategoriaGateway categoriaGateway(CategoriaRepository categoriaRepository, CategoriaEntityMapper categoriaEntityMapper) {
        return new CategoriaRepositoryGateway(categoriaRepository, categoriaEntityMapper);
    }

    @Bean
    CadastraCategoriaInteractor cadastraCategoriaUseCase(CategoriaGateway categoriaGateway) {
        return new CadastraCategoriaInteractor(categoriaGateway);
    }

    @Bean
    CategoriaDTOMapper categoriaDTOMapper() {
        return new CategoriaDTOMapper();
    }
}
