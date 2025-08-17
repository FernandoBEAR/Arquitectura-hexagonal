package com.allfym.ms.hexagonal.almacen.application.usecases.movimientos;

import com.allfym.ms.hexagonal.almacen.domain.models.Movimiento;
import com.allfym.ms.hexagonal.almacen.domain.ports.in.movimiento.UpdateMovimientoUsecase;
import com.allfym.ms.hexagonal.almacen.domain.ports.out.MovimientoRepositoryPort;

import java.util.Optional;

public class UpdateMovimientoUseCaseImpl implements UpdateMovimientoUsecase {

   private final MovimientoRepositoryPort movimientoRepositoryPort;

    public UpdateMovimientoUseCaseImpl(MovimientoRepositoryPort movimientoRepositoryPort) {
        this.movimientoRepositoryPort = movimientoRepositoryPort;
    }

    @Override
    public Optional<Movimiento> updateMovimiento(Movimiento movimiento, Long idMovimiento) {
        return movimientoRepositoryPort.update(movimiento);
    }
}
