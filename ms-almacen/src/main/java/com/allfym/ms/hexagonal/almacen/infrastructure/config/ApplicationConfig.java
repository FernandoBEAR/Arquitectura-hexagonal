package com.allfym.ms.hexagonal.almacen.infrastructure.config;

import com.allfym.ms.hexagonal.almacen.application.services.AlmacenProductoService;
import com.allfym.ms.hexagonal.almacen.application.usecases.almacenproducto.*;
import com.allfym.ms.hexagonal.almacen.application.usecases.movimientos.CreateMovimientoUseCaseImpl;
import com.allfym.ms.hexagonal.almacen.domain.ports.out.AlmacenProductoRepositoryPort;
import com.allfym.ms.hexagonal.almacen.domain.ports.out.ExternalServicePort;
import com.allfym.ms.hexagonal.almacen.domain.ports.out.MovimientoRepositoryPort;
import com.allfym.ms.hexagonal.almacen.infrastructure.adapters.ExternalServiceAdapter;
import com.allfym.ms.hexagonal.almacen.infrastructure.repositories.JpaAlmacenProductoRepository;
import com.allfym.ms.hexagonal.almacen.infrastructure.repositories.JpaAlmacenProductoRepositoryAdapter;
import com.allfym.ms.hexagonal.almacen.infrastructure.repositories.JpaMovimientoRepository;
import com.allfym.ms.hexagonal.almacen.infrastructure.repositories.JpaMovimientoRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {

    @Bean
    public AlmacenProductoService almacenProductoService(
            AlmacenProductoRepositoryPort almacenProductoRepositoryPort,
            ExternalServicePort externalServicePort,
            CreateMovimientoUseCaseImpl createMovimientoUseCase) {
        return new AlmacenProductoService(
                new CreateAlmacenProductoUseCaseImpl(almacenProductoRepositoryPort, createMovimientoUseCase, externalServicePort),
                new DeleteAlmacenProductoUseCaseImpl(almacenProductoRepositoryPort),
                new RetrieveAlmacenProductoUseCaseImpl(almacenProductoRepositoryPort),
                new UpdateAlmacenProductoUseCaseImpl(almacenProductoRepositoryPort),
                new AumentarStockAlmacenProductoUseCaseImpl(almacenProductoRepositoryPort, externalServicePort, createMovimientoUseCase),
                new ReducirStockAlmacenProductoUseCaseImpl(almacenProductoRepositoryPort, externalServicePort, createMovimientoUseCase),
                new ObtenerHistorialMovimientosUseCaseImpl(almacenProductoRepositoryPort)
        );
    }

    @Bean
    AlmacenProductoRepositoryPort almacenProductoRepositoryPort(JpaAlmacenProductoRepositoryAdapter jpaAlmacenProductoRepositoryAdapter){
        return jpaAlmacenProductoRepositoryAdapter;
    }

    @Bean
    public ExternalServicePort externalServicePort() {
        return new ExternalServiceAdapter(new RestTemplate());
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CreateMovimientoUseCaseImpl createMovimientoUseCase(MovimientoRepositoryPort movimientoRepositoryPort) {
        return new CreateMovimientoUseCaseImpl(movimientoRepositoryPort);
    }

    @Bean
    public MovimientoRepositoryPort movimientoRepositoryPort(JpaMovimientoRepositoryAdapter adapter) {
        return adapter;
    }

    @Bean
    public JpaMovimientoRepositoryAdapter jpaMovimientoRepositoryAdapter(JpaMovimientoRepository repository) {
        return new JpaMovimientoRepositoryAdapter(repository);
    }

    @Bean
    public JpaAlmacenProductoRepositoryAdapter jpaAlmacenProductoRepositoryAdapter(JpaAlmacenProductoRepository repository) {
        return new JpaAlmacenProductoRepositoryAdapter(repository);
    }

}
