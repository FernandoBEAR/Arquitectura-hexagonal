package com.allfym.ms.hexagonal.almacen.domain.ports.in.movimiento;

import com.allfym.ms.hexagonal.almacen.domain.models.Movimiento;

import java.util.Optional;

public interface UpdateMovimientoUsecase {
    Optional<Movimiento> updateMovimiento(Movimiento movimiento, Long idMovimiento);

}
