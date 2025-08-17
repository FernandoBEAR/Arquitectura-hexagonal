package com.allfym.ms.hexagonal.productos.application.usecases;

import com.allfym.ms.hexagonal.productos.domain.models.Producto;
import com.allfym.ms.hexagonal.productos.domain.ports.in.RetrieveProductouseCase;
import com.allfym.ms.hexagonal.productos.domain.ports.out.ProductoRepositoryPort;
import com.allfym.ms.hexagonal.productos.infrastructure.entities.Categoria;
import com.allfym.ms.hexagonal.productos.infrastructure.entities.Marca;

import java.util.List;
import java.util.Optional;

public class RetrieveProductoUseCaseImpl implements RetrieveProductouseCase {

    private final ProductoRepositoryPort productoRepositoryPort;

    public RetrieveProductoUseCaseImpl(ProductoRepositoryPort productoRepositoryPort) {
        this.productoRepositoryPort = productoRepositoryPort;
    }

    @Override
    public Optional<Producto> getProductById(Long id) {
        return productoRepositoryPort.findById(id);
    }

    @Override
    public List<Producto> getAllProducts() {
        return productoRepositoryPort.findAll();
    }

    @Override
    public List<Producto> findByCategoria(Categoria categoria) {
        return productoRepositoryPort.findByCategoria(categoria);
    }

    @Override
    public List<Producto> findByMarca(Marca marca) {
        return productoRepositoryPort.findByMarca(marca);
    }
}
