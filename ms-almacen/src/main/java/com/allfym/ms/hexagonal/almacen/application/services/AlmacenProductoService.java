package com.allfym.ms.hexagonal.almacen.application.services;

import com.allfym.ms.hexagonal.almacen.domain.models.AlmacenProducto;
import com.allfym.ms.hexagonal.almacen.domain.models.Movimiento;
import com.allfym.ms.hexagonal.almacen.domain.ports.in.almacenproducto.*;

import java.util.List;
import java.util.Optional;

public class AlmacenProductoService implements CreateAlmacenProductoUseCase, DeleteAlmacenProductoUseCase, RetrieveAlmacenProductoUseCase, UpdateAlmacenProductoUseCase, AumentarStockAlmacenProductoUseCase, ReducirStockAlmacenProductoUseCase, ObtenerHistorialMovimientosUseCase {

    private final CreateAlmacenProductoUseCase createAlmacenProductoUseCase;
    private final DeleteAlmacenProductoUseCase deleteAlmacenProductoUseCase;
    private final RetrieveAlmacenProductoUseCase retrieveAlmacenProductoUseCase;
    private final UpdateAlmacenProductoUseCase updateAlmacenProductoUseCase;
    private final AumentarStockAlmacenProductoUseCase aumentarStockAlmacenProductoUseCase;
    private final ReducirStockAlmacenProductoUseCase reducirStockAlmacenProductoUseCase;
    private final ObtenerHistorialMovimientosUseCase obtenerHistorialMovimientosUseCase;

    public AlmacenProductoService(CreateAlmacenProductoUseCase createAlmacenProductoUseCase, DeleteAlmacenProductoUseCase deleteAlmacenProductoUseCase, RetrieveAlmacenProductoUseCase retrieveAlmacenProductoUseCase, UpdateAlmacenProductoUseCase updateAlmacenProductoUseCase, AumentarStockAlmacenProductoUseCase aumentarStockAlmacenProductoUseCase, ReducirStockAlmacenProductoUseCase reducirStockAlmacenProductoUseCase, ObtenerHistorialMovimientosUseCase obtenerHistorialMovimientosUseCase) {
        this.createAlmacenProductoUseCase = createAlmacenProductoUseCase;
        this.deleteAlmacenProductoUseCase = deleteAlmacenProductoUseCase;
        this.retrieveAlmacenProductoUseCase = retrieveAlmacenProductoUseCase;
        this.updateAlmacenProductoUseCase = updateAlmacenProductoUseCase;
        this.aumentarStockAlmacenProductoUseCase = aumentarStockAlmacenProductoUseCase;
        this.reducirStockAlmacenProductoUseCase = reducirStockAlmacenProductoUseCase;
        this.obtenerHistorialMovimientosUseCase = obtenerHistorialMovimientosUseCase;
    }


    @Override
    public List<Movimiento> obtenerHistorialMovimientos(Long idProducto) {
        return obtenerHistorialMovimientosUseCase.obtenerHistorialMovimientos(idProducto);
    }

    @Override
    public AlmacenProducto createAlmacenProducto(Long idProducto, Integer stockInicial) throws Exception {
        return createAlmacenProductoUseCase.createAlmacenProducto(idProducto, stockInicial);
    }

    @Override
    public boolean deleteAlmacenProductoById(Long idProducto) {
        return deleteAlmacenProductoUseCase.deleteAlmacenProductoById(idProducto);
    }

    @Override
    public Optional<AlmacenProducto> getAlmacenProductById(Long id) {
        return retrieveAlmacenProductoUseCase.getAlmacenProductById(id);
    }

    @Override
    public List<AlmacenProducto> getAllAlmacenProducts() {
        return retrieveAlmacenProductoUseCase.getAllAlmacenProducts();
    }

    @Override
    public Optional<AlmacenProducto> updateProducto(AlmacenProducto almacenProductoActualizado, Long idProducto) {
        return updateAlmacenProductoUseCase.updateProducto(almacenProductoActualizado, idProducto);
    }


    @Override
    public AlmacenProducto aumentarStock(Long idProducto, Integer cantidad) {
        return aumentarStockAlmacenProductoUseCase.aumentarStock(idProducto, cantidad);
    }

    @Override
    public AlmacenProducto reducirStock(Long idProducto, int cantidad) {
        return reducirStockAlmacenProductoUseCase.reducirStock(idProducto, cantidad);
    }

}
