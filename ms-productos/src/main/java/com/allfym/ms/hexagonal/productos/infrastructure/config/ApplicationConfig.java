package com.allfym.ms.hexagonal.productos.infrastructure.config;

import com.allfym.ms.hexagonal.productos.application.services.ProductoService;
import com.allfym.ms.hexagonal.productos.application.usecases.CreateProductoUseCaseImpl;
import com.allfym.ms.hexagonal.productos.application.usecases.DeleteProductoUseCaseImpl;
import com.allfym.ms.hexagonal.productos.application.usecases.RetrieveProductoUseCaseImpl;
import com.allfym.ms.hexagonal.productos.application.usecases.UpdateProductoUseCaseImpl;
import com.allfym.ms.hexagonal.productos.domain.ports.out.ExternalServicePort;
import com.allfym.ms.hexagonal.productos.domain.ports.out.ProductoRepositoryPort;
import com.allfym.ms.hexagonal.productos.infrastructure.repositories.JpaProductoRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public ProductoService productoService(ProductoRepositoryPort productoRepositoryPort) {
        return new ProductoService(
                new CreateProductoUseCaseImpl(productoRepositoryPort),
                new DeleteProductoUseCaseImpl(productoRepositoryPort),
                new RetrieveProductoUseCaseImpl(productoRepositoryPort),
                new UpdateProductoUseCaseImpl(productoRepositoryPort)
        );
    }

    @Bean
    ProductoRepositoryPort productoRepositoryPort(JpaProductoRepositoryAdapter jpaProductoRepositoryAdapter) {
        return jpaProductoRepositoryAdapter;
    }

//    @Bean
//    public ExternalServicePort externalServicePort() {
//        return new ExternalServicePort();
//    }

}
