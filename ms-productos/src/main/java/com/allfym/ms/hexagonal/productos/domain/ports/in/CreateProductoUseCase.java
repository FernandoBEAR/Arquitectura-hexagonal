package com.allfym.ms.hexagonal.productos.domain.ports.in;

import com.allfym.ms.hexagonal.productos.domain.models.Producto;

import java.util.List;

public interface CreateProductoUseCase {
    Producto createProduct(Producto producto);
}