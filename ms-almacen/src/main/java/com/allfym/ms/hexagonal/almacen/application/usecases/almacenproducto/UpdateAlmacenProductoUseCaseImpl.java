package com.allfym.ms.hexagonal.almacen.application.usecases.almacenproducto;

import com.allfym.ms.hexagonal.almacen.domain.models.AlmacenProducto;
import com.allfym.ms.hexagonal.almacen.domain.ports.in.almacenproducto.UpdateAlmacenProductoUseCase;
import com.allfym.ms.hexagonal.almacen.domain.ports.out.AlmacenProductoRepositoryPort;

import java.util.Optional;

public class UpdateAlmacenProductoUseCaseImpl implements UpdateAlmacenProductoUseCase {

    private final AlmacenProductoRepositoryPort almacenProductoRepositoryPort;

    public UpdateAlmacenProductoUseCaseImpl(AlmacenProductoRepositoryPort almacenProductoRepositoryPort) {
        this.almacenProductoRepositoryPort = almacenProductoRepositoryPort;
    }

    @Override
    public Optional<AlmacenProducto> updateProducto(AlmacenProducto almacenProductoActualizado, Long idProducto) {
        return almacenProductoRepositoryPort.update(almacenProductoActualizado);
    }
}
