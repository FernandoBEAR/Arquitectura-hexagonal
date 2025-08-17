package com.allfym.ms.hexagonal.almacen.application.usecases.almacenproducto;

import com.allfym.ms.hexagonal.almacen.application.usecases.movimientos.CreateMovimientoUseCaseImpl;
import com.allfym.ms.hexagonal.almacen.domain.models.AlmacenProducto;
import com.allfym.ms.hexagonal.almacen.domain.ports.in.almacenproducto.AumentarStockAlmacenProductoUseCase;
import com.allfym.ms.hexagonal.almacen.domain.ports.out.AlmacenProductoRepositoryPort;
import com.allfym.ms.hexagonal.almacen.domain.ports.out.ExternalServicePort;
import com.allfym.ms.hexagonal.almacen.infrastructure.entities.TipoMovimiento;

public class AumentarStockAlmacenProductoUseCaseImpl implements AumentarStockAlmacenProductoUseCase {

    private final AlmacenProductoRepositoryPort almacenProductoRepositoryPort;
    private final ExternalServicePort externalServicePort;
    private final CreateMovimientoUseCaseImpl createMovimientoUseCase;

    public AumentarStockAlmacenProductoUseCaseImpl(AlmacenProductoRepositoryPort almacenProductoRepositoryPort, ExternalServicePort externalServicePort, CreateMovimientoUseCaseImpl createMovimientoUseCase) {
        this.almacenProductoRepositoryPort = almacenProductoRepositoryPort;
        this.externalServicePort = externalServicePort;
        this.createMovimientoUseCase = createMovimientoUseCase;
    }

    @Override
    public AlmacenProducto aumentarStock(Long idProducto, Integer cantidad) {
        externalServicePort.getProductoById(idProducto); // Valida existencia

        AlmacenProducto almacenProducto = almacenProductoRepositoryPort.findByIdProducto(idProducto)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado en almacén"));

        almacenProducto.setStock(almacenProducto.getStock() + cantidad);

        // Crear el movimiento y agregarlo al almacenProducto
        createMovimientoUseCase.createMovimiento(almacenProducto, TipoMovimiento.ENTRADA, cantidad);

        // Guardar el almacenProducto con el movimiento incluido
        return almacenProductoRepositoryPort.save(almacenProducto);
    }
}
