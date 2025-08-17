package com.allfym.ms.hexagonal.almacen.domain.ports.out;

import com.allfym.ms.hexagonal.almacen.domain.models.AlmacenProducto;

import java.util.List;
import java.util.Optional;

public interface AlmacenProductoRepositoryPort {
    AlmacenProducto save(AlmacenProducto almacenProducto);
    List<AlmacenProducto> findAll();
    Optional<AlmacenProducto> findById(Long id);
    Optional<AlmacenProducto> findByIdProducto(Long idProducto); //
    Optional<AlmacenProducto> update(AlmacenProducto almacenProducto);
    boolean deleteByIdProducto(Long idAlmacen);
}

