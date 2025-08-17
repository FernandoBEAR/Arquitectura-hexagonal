package com.allfym.ms.hexagonal.productos.application.usecases;

import com.allfym.ms.hexagonal.productos.domain.ports.in.DeleteProductoUseCase;
import com.allfym.ms.hexagonal.productos.domain.ports.out.ProductoRepositoryPort;

public class DeleteProductoUseCaseImpl implements DeleteProductoUseCase {

    private final ProductoRepositoryPort productoRepository;

    public DeleteProductoUseCaseImpl(ProductoRepositoryPort productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public boolean deleteProductoById(Long id) {
        return productoRepository.deleteById(id);
    }
}
