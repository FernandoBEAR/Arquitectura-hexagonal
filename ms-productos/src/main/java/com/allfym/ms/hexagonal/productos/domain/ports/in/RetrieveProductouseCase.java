package com.allfym.ms.hexagonal.productos.domain.ports.in;

import com.allfym.ms.hexagonal.productos.domain.models.Producto;
import com.allfym.ms.hexagonal.productos.infrastructure.entities.Categoria;
import com.allfym.ms.hexagonal.productos.infrastructure.entities.Marca;

import java.util.List;
import java.util.Optional;

public interface RetrieveProductouseCase {
    Optional<Producto> getProductById(Long id);
    List<Producto> getAllProducts();
    List<Producto> findByCategoria(Categoria categoria);
    List<Producto> findByMarca(Marca marca);
}
