package com.allfym.ms.hexagonal.productos.infrastructure.repositories;

import com.allfym.ms.hexagonal.productos.domain.models.Producto;
import com.allfym.ms.hexagonal.productos.infrastructure.entities.Categoria;
import com.allfym.ms.hexagonal.productos.infrastructure.entities.Marca;
import com.allfym.ms.hexagonal.productos.infrastructure.entities.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface JpaProductoRepository extends JpaRepository<ProductoEntity, Long> {

    List<ProductoEntity> findByCategoria(Categoria categoria);
    List<ProductoEntity> findByMarca(Marca marca);
}
