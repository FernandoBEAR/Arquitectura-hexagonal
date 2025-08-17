package com.allfym.ms.hexagonal.productos.application.usecases;

import com.allfym.ms.hexagonal.productos.domain.models.Producto;
import com.allfym.ms.hexagonal.productos.domain.ports.in.UpdateProductoUseCase;
import com.allfym.ms.hexagonal.productos.domain.ports.out.ProductoRepositoryPort;

import java.util.Optional;

public class UpdateProductoUseCaseImpl implements UpdateProductoUseCase {

    private final ProductoRepositoryPort productoRepositoryPort;

    public UpdateProductoUseCaseImpl(ProductoRepositoryPort productoRepositoryPort) {
        this.productoRepositoryPort = productoRepositoryPort;
    }

    @Override
    public Optional<Producto> updateProducto(Producto productoActualizado, Long idProducto) {
        return productoRepositoryPort.update(productoActualizado);
    }
}
