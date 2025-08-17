package com.allfym.ms.hexagonal.productos.application.usecases;

import com.allfym.ms.hexagonal.productos.domain.models.Producto;
import com.allfym.ms.hexagonal.productos.domain.ports.in.CreateProductoUseCase;
import com.allfym.ms.hexagonal.productos.domain.ports.out.ProductoRepositoryPort;

public class CreateProductoUseCaseImpl implements CreateProductoUseCase {

    private final ProductoRepositoryPort productoRepositoryPort;

    public CreateProductoUseCaseImpl(ProductoRepositoryPort productoRepositoryPort) {
        this.productoRepositoryPort = productoRepositoryPort;
    }

    @Override
    public Producto createProduct(Producto producto) {
        return productoRepositoryPort.save(producto);
    }
}
