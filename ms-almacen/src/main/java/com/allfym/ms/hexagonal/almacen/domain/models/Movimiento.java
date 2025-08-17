package com.allfym.ms.hexagonal.almacen.domain.models;

import com.allfym.ms.hexagonal.almacen.infrastructure.entities.FechaMovimiento;
import com.allfym.ms.hexagonal.almacen.infrastructure.entities.TipoMovimiento;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movimiento {
    private Long idMovimiento;
    private FechaMovimiento fechaMovimiento;
    private TipoMovimiento tipoMovimiento;
    private Integer cantidadDeMovimientos;

    @JsonBackReference
    private AlmacenProducto almacenProducto;
}