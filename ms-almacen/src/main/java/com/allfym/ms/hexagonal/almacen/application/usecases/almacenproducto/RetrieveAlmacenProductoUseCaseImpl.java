package com.allfym.ms.hexagonal.almacen.application.usecases.almacenproducto;

import com.allfym.ms.hexagonal.almacen.domain.models.AlmacenProducto;
import com.allfym.ms.hexagonal.almacen.domain.ports.in.almacenproducto.RetrieveAlmacenProductoUseCase;
import com.allfym.ms.hexagonal.almacen.domain.ports.out.AlmacenProductoRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveAlmacenProductoUseCaseImpl implements RetrieveAlmacenProductoUseCase {

    private final AlmacenProductoRepositoryPort almacenProductoRepositoryPort;

    public RetrieveAlmacenProductoUseCaseImpl(AlmacenProductoRepositoryPort almacenProductoRepositoryPort) {
        this.almacenProductoRepositoryPort = almacenProductoRepositoryPort;
    }


    @Override
    public Optional<AlmacenProducto> getAlmacenProductById(Long id) {
        return almacenProductoRepositoryPort.findByIdAlmacen(id);
    }

    @Override
    public List<AlmacenProducto> getAllAlmacenProducts() {
        return almacenProductoRepositoryPort.findAll();
    }
}
