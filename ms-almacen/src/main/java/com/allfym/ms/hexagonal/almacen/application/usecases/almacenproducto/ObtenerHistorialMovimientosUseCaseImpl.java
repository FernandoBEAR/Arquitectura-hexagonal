package com.allfym.ms.hexagonal.almacen.application.usecases.almacenproducto;

import com.allfym.ms.hexagonal.almacen.domain.models.AlmacenProducto;
import com.allfym.ms.hexagonal.almacen.domain.models.Movimiento;
import com.allfym.ms.hexagonal.almacen.domain.ports.in.almacenproducto.ObtenerHistorialMovimientosUseCase;
import com.allfym.ms.hexagonal.almacen.domain.ports.out.AlmacenProductoRepositoryPort;

import java.util.List;

public class ObtenerHistorialMovimientosUseCaseImpl implements ObtenerHistorialMovimientosUseCase {
    private final AlmacenProductoRepositoryPort almacenProductoRepositoryPort;

    public ObtenerHistorialMovimientosUseCaseImpl(AlmacenProductoRepositoryPort almacenProductoRepositoryPort) {
        this.almacenProductoRepositoryPort = almacenProductoRepositoryPort;
    }

    @Override
    public List<Movimiento> obtenerHistorialMovimientos(Long idAlmacen) {
        AlmacenProducto almacenProducto = almacenProductoRepositoryPort.findByIdAlmacen(idAlmacen)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado en almacén"));

        return almacenProducto.getMovimientos();
    }
}
