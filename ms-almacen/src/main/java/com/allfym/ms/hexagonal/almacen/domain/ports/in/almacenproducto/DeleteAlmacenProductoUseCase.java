package com.allfym.ms.hexagonal.almacen.domain.ports.in.almacenproducto;


public interface DeleteAlmacenProductoUseCase {
    boolean deleteAlmacenById(Long idAlmacen);
}
