package com.allfym.ms.hexagonal.almacen.domain.ports.in.almacenproducto;

import com.allfym.ms.hexagonal.almacen.domain.models.AlmacenProducto;

import java.util.Optional;

public interface UpdateAlmacenProductoUseCase {

    Optional<AlmacenProducto> updateProducto(AlmacenProducto almacenProductoActualizado, Long idProducto);
}
