package com.allfym.ms.hexagonal.almacen.domain.ports.out;

import com.allfym.ms.hexagonal.almacen.domain.models.Movimiento;
import com.allfym.ms.hexagonal.almacen.infrastructure.entities.TipoMovimiento;

import java.util.List;
import java.util.Optional;

public interface MovimientoRepositoryPort {
    Movimiento save(Movimiento movimiento);
    List<Movimiento> findAll();
    Optional<Movimiento> findById(Long id);
    List<Movimiento> findByTipoMovimiento(TipoMovimiento tipoMovimiento);
    Optional<Movimiento> update(Movimiento movimiento);
    boolean deleteById(Long id);
}
