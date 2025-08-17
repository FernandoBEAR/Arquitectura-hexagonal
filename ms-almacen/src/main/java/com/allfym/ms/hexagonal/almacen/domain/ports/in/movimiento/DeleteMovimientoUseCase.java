package com.allfym.ms.hexagonal.almacen.domain.ports.in.movimiento;

public interface DeleteMovimientoUseCase {
    boolean deleteMovimientoById(Long idMovimiento);
}
