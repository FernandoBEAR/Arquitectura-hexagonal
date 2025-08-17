package com.allfym.ms.hexagonal.almacen.infrastructure.controllers;

import com.allfym.ms.hexagonal.almacen.application.services.AlmacenProductoService;
import com.allfym.ms.hexagonal.almacen.domain.models.AlmacenProducto;
import com.allfym.ms.hexagonal.almacen.domain.models.Movimiento;
import com.allfym.ms.hexagonal.almacen.infrastructure.entities.pojo.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/almacen")
public class AlmacenProductoController {

    @Autowired
    AlmacenProductoService almacenProductoService;

    @PostMapping("/producto/{idProducto}/agregar-stock/{stockInicial}")
    public ResponseEntity<?> agregarProductoAlmacen(@PathVariable Long idProducto, @PathVariable Integer stockInicial) {
        try {
            AlmacenProducto almacenProducto = almacenProductoService.createAlmacenProducto(idProducto, stockInicial);
            return ResponseEntity.status(HttpStatus.CREATED).body(almacenProducto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/producto/{idProducto}/aumentar-stock/{cantidad}")
    public ResponseEntity<?> aumentarStock(@PathVariable Long idProducto, @PathVariable Integer cantidad) {
        try {
            AlmacenProducto almacenProducto = almacenProductoService.aumentarStock(idProducto, cantidad);
            return ResponseEntity.ok(almacenProducto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/producto/{idProducto}/reducir-stock/{cantidad}")
    public ResponseEntity<?> reducirStock(@PathVariable Long idProducto, @PathVariable Integer cantidad) {
        try {
            AlmacenProducto almacenProducto = almacenProductoService.reducirStock(idProducto, cantidad);
            return ResponseEntity.ok(almacenProducto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/producto/{idProducto}/historial-movimientos")
    public ResponseEntity<List<Movimiento>> obtenerHistorialMovimientos(@PathVariable Long idProducto) {
        List<Movimiento> movimientos = almacenProductoService.obtenerHistorialMovimientos(idProducto);
        return ResponseEntity.ok(movimientos);
    }

    @GetMapping("/productos")
    public ResponseEntity<List<AlmacenProducto>> listarProductosSimple() {
        List<AlmacenProducto> productos = almacenProductoService.getAllAlmacenProducts();
        return ResponseEntity.ok(productos);
    }

    @DeleteMapping("/producto/{idProducto}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Long idProducto) {
        try {
            almacenProductoService.deleteAlmacenProductoById(idProducto);
            return ResponseEntity.ok("Producto eliminado correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
