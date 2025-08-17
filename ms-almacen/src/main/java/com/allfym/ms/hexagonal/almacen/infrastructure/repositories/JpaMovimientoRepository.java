package com.allfym.ms.hexagonal.almacen.infrastructure.repositories;

import com.allfym.ms.hexagonal.almacen.infrastructure.entities.MovimientoEntity;
import com.allfym.ms.hexagonal.almacen.infrastructure.entities.TipoMovimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface JpaMovimientoRepository extends JpaRepository<MovimientoEntity, Long> {
    List<MovimientoEntity> findByTipoMovimiento(TipoMovimiento tipoMovimiento);
}
