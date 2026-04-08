package com.marcosmontenegro.Controller;

import com.marcosmontenegro.Entity.DetalleVenta;
import com.marcosmontenegro.Service.DetalleVentaService;
import com.marcosmontenegro.Exception.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/detalles-venta")
public class DetalleVentaController {

    @Autowired
    private DetalleVentaService service;

    @GetMapping
    public List<DetalleVenta> getAll() {
        return service.getAllDetalles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleVenta> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getDetalleById(id));
    }

    @PostMapping
    public ResponseEntity<DetalleVenta> save(@RequestBody DetalleVenta detalle) {
        return ResponseEntity.ok(service.saveDetalle(detalle));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleVenta> update(@PathVariable Integer id, @RequestBody DetalleVenta detalle) {
        return ResponseEntity.ok(service.updateDetalle(id, detalle));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ErrorResponse> delete(@PathVariable Integer id) {
        service.deleteDetalle(id);
        return ResponseEntity.ok(new ErrorResponse("Detalle eliminado correctamente"));
    }
}
