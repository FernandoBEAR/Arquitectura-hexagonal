package com.allfym.ms.hexagonal.almacen.domain.ports.in.almacenproducto;

import com.allfym.ms.hexagonal.almacen.domain.models.AlmacenProducto;

public interface AumentarStockAlmacenProductoUseCase {
    AlmacenProducto aumentarStock(Long idAlmacen, Integer cantidad);
}
