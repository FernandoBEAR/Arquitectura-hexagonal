package com.allfym.ms.hexagonal.productos.domain.models;

import com.allfym.ms.hexagonal.productos.infrastructure.entities.Categoria;
import com.allfym.ms.hexagonal.productos.infrastructure.entities.Marca;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Producto {
    private Long id;
    private String nombre;
    private String descripcion;
    private double precio;
    private Categoria categoria;
    private Marca marca;
}