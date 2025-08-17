package com.allfym.ms.hexagonal.productos.domain.ports.out;

import com.allfym.ms.hexagonal.productos.domain.models.Producto;
import com.allfym.ms.hexagonal.productos.infrastructure.entities.Categoria;
import com.allfym.ms.hexagonal.productos.infrastructure.entities.Marca;

import java.util.List;
import java.util.Optional;

public interface ProductoRepositoryPort {
    Producto save(Producto producto);
    List<Producto> findAll();
    Optional<Producto> findById(Long id);
    List<Producto> findByCategoria(Categoria categoria);
    List<Producto> findByMarca(Marca marca);
    Optional<Producto> update(Producto producto);
    boolean deleteById(Long id);
}
