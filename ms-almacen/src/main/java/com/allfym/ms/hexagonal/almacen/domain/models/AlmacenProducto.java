package com.allfym.ms.hexagonal.almacen.domain.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlmacenProducto {


    private Long idAlmacen;
    private Integer stock;
    private Long idProducto;
    private List<Movimiento> movimientos = new ArrayList<>();
}
