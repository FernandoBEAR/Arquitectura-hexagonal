package com.allfym.ms.hexagonal.almacen.domain.ports.in.almacenproducto;

import com.allfym.ms.hexagonal.almacen.domain.models.AlmacenProducto;

public interface CreateAlmacenProductoUseCase {
    AlmacenProducto createAlmacenProducto(Long idProducto, Integer stockInicial) throws Exception;
}
