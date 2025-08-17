package com.allfym.ms.hexagonal.productos.domain.ports.in;

import com.allfym.ms.hexagonal.productos.domain.models.Producto;

import java.util.Optional;

public interface UpdateProductoUseCase {
    Optional<Producto> updateProducto(Producto productoActualizado, Long idProducto);
}
