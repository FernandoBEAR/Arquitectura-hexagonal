package com.allfym.ms.hexagonal.almacen.application.usecases.almacenproducto;

import com.allfym.ms.hexagonal.almacen.application.usecases.movimientos.CreateMovimientoUseCaseImpl;
import com.allfym.ms.hexagonal.almacen.domain.models.AlmacenProducto;
import com.allfym.ms.hexagonal.almacen.domain.ports.in.almacenproducto.ReducirStockAlmacenProductoUseCase;
import com.allfym.ms.hexagonal.almacen.domain.ports.out.AlmacenProductoRepositoryPort;
import com.allfym.ms.hexagonal.almacen.domain.ports.out.ExternalServicePort;
import com.allfym.ms.hexagonal.almacen.infrastructure.entities.TipoMovimiento;

public class ReducirStockAlmacenProductoUseCaseImpl implements ReducirStockAlmacenProductoUseCase {

    private final AlmacenProductoRepositoryPort almacenProductoRepositoryPort;
    private final ExternalServicePort externalServicePort;
    private final CreateMovimientoUseCaseImpl createMovimientoUseCase;

    public ReducirStockAlmacenProductoUseCaseImpl(AlmacenProductoRepositoryPort almacenProductoRepositoryPort, ExternalServicePort externalServicePort, CreateMovimientoUseCaseImpl createMovimientoUseCase) {
        this.almacenProductoRepositoryPort = almacenProductoRepositoryPort;
        this.externalServicePort = externalServicePort;
        this.createMovimientoUseCase = createMovimientoUseCase;
    }

    @Override
    public AlmacenProducto reducirStock(Long idAlmacen, Integer cantidad) {

        AlmacenProducto almacenProducto = almacenProductoRepositoryPort.findByIdAlmacen(idAlmacen)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado en almacén"));

        almacenProducto.setStock(almacenProducto.getStock() - cantidad);

        // Crear el movimiento y agregarlo al almacenProducto
        createMovimientoUseCase.createMovimiento(almacenProducto, TipoMovimiento.SALIDA, cantidad);

        // Guardar el almacenProducto con el movimiento incluido
        return almacenProductoRepositoryPort.save(almacenProducto);
    }
}
