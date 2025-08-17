package com.allfym.ms.hexagonal.almacen.domain.ports.in.movimiento;

import com.allfym.ms.hexagonal.almacen.domain.models.Movimiento;
import com.allfym.ms.hexagonal.almacen.infrastructure.entities.TipoMovimiento;

import java.util.List;
import java.util.Optional;

public interface RetrieveMovimientoUseCase {
    Optional<Movimiento> getMovimientoById(Long id);
    List<Movimiento> getAllMovimientos();
    List<Movimiento> findByTipoMovimiento(TipoMovimiento tipoMovimiento);
}
