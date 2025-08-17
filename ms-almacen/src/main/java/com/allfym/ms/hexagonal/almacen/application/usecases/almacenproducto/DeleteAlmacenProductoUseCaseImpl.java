package com.allfym.ms.hexagonal.almacen.application.usecases.almacenproducto;

import com.allfym.ms.hexagonal.almacen.domain.ports.in.almacenproducto.DeleteAlmacenProductoUseCase;
import com.allfym.ms.hexagonal.almacen.domain.ports.out.AlmacenProductoRepositoryPort;

public class DeleteAlmacenProductoUseCaseImpl implements DeleteAlmacenProductoUseCase {

   private final AlmacenProductoRepositoryPort almacenProductoRepositoryPort;

    public DeleteAlmacenProductoUseCaseImpl(AlmacenProductoRepositoryPort almacenProductoRepositoryPort) {
        this.almacenProductoRepositoryPort = almacenProductoRepositoryPort;
    }

    @Override
    public boolean deleteAlmacenProductoById(Long idProducto) {
        return almacenProductoRepositoryPort.deleteByIdProducto(idProducto);
    }
}
