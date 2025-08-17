package com.allfym.ms.hexagonal.productos.domain.ports.in;

public interface DeleteProductoUseCase {

    boolean deleteProductoById(Long id);
}
