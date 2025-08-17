package com.allfym.ms.hexagonal.almacen.application.usecases.movimientos;

import com.allfym.ms.hexagonal.almacen.domain.models.AlmacenProducto;
import com.allfym.ms.hexagonal.almacen.domain.models.Movimiento;
import com.allfym.ms.hexagonal.almacen.domain.ports.in.movimiento.CreateMovimientoUseCase;
import com.allfym.ms.hexagonal.almacen.domain.ports.out.MovimientoRepositoryPort;
import com.allfym.ms.hexagonal.almacen.infrastructure.entities.FechaMovimiento;
import com.allfym.ms.hexagonal.almacen.infrastructure.entities.TipoMovimiento;

import java.time.LocalDate;

public class CreateMovimientoUseCaseImpl implements CreateMovimientoUseCase {

    private final MovimientoRepositoryPort movimientoRepositoryPort;

    public CreateMovimientoUseCaseImpl(MovimientoRepositoryPort movimientoRepositoryPort) {
        this.movimientoRepositoryPort = movimientoRepositoryPort;
    }

    @Override
    public Movimiento createMovimiento(AlmacenProducto almacenProducto, TipoMovimiento tipoMovimiento, Integer cantidad) {
        Movimiento movimiento = new Movimiento();
        movimiento.setTipoMovimiento(tipoMovimiento);
        movimiento.setCantidadDeMovimientos(cantidad);
        movimiento.setFechaMovimiento(new FechaMovimiento()); // Asigna fecha actual

        // Agregar el movimiento a la lista del almacenProducto
        almacenProducto.getMovimientos().add(movimiento);

        return movimiento; // No guardes aquí, se guardará con el AlmacenProducto
    }
}