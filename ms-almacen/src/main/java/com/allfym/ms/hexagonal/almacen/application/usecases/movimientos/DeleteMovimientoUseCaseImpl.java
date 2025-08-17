package com.allfym.ms.hexagonal.almacen.application.usecases.movimientos;

import com.allfym.ms.hexagonal.almacen.domain.ports.in.movimiento.DeleteMovimientoUseCase;
import com.allfym.ms.hexagonal.almacen.domain.ports.out.MovimientoRepositoryPort;

public class DeleteMovimientoUseCaseImpl implements DeleteMovimientoUseCase {

    private final MovimientoRepositoryPort movimientoRepositoryPort;

    public DeleteMovimientoUseCaseImpl(MovimientoRepositoryPort movimientoRepositoryPort) {
        this.movimientoRepositoryPort = movimientoRepositoryPort;
    }

    @Override
    public boolean deleteMovimientoById(Long idMovimiento) {
        return movimientoRepositoryPort.deleteById(idMovimiento);
    }
}
