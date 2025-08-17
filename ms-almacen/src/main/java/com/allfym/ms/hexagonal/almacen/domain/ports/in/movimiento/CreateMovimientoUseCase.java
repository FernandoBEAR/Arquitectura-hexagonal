package com.allfym.ms.hexagonal.almacen.domain.ports.in.movimiento;

import com.allfym.ms.hexagonal.almacen.domain.models.Movimiento;
import com.allfym.ms.hexagonal.almacen.domain.models.AlmacenProducto;
import com.allfym.ms.hexagonal.almacen.infrastructure.entities.TipoMovimiento;

public interface CreateMovimientoUseCase {
    Movimiento createMovimiento(AlmacenProducto almacenProducto, TipoMovimiento tipo, Integer cantidad);
}
