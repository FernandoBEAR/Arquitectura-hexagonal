package com.allfym.ms.hexagonal.almacen.domain.ports.in.almacenproducto;

import com.allfym.ms.hexagonal.almacen.domain.models.Movimiento;

import java.util.List;

public interface ObtenerHistorialMovimientosUseCase {
    List<Movimiento> obtenerHistorialMovimientos(Long idProducto);
}
