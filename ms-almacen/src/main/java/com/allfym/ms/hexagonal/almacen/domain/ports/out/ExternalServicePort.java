package com.allfym.ms.hexagonal.almacen.domain.ports.out;

import com.allfym.ms.hexagonal.almacen.infrastructure.entities.pojo.Producto;

public interface ExternalServicePort {
    Producto getProductoById(Long idProducto);
}
