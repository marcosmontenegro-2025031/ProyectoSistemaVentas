package com.marcosmontenegro.Controller;

import com.marcosmontenegro.Entity.Venta;
import com.marcosmontenegro.Exception.ErrorResponse;
import com.marcosmontenegro.Service.VentaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private VentaService service;

    @GetMapping
    public List<Venta> getAll() {
        return service.getAllVentas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getVentaById(id));
    }

    @PostMapping
    public ResponseEntity<Venta> save(@Valid @RequestBody Venta venta) {
        return ResponseEntity.ok(service.saveVenta(venta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venta> update(@PathVariable Integer id, @Valid @RequestBody Venta venta) {
        return ResponseEntity.ok(service.updateVenta(id, venta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ErrorResponse> delete(@PathVariable Integer id) {
    service.deleteVenta(id);
    return ResponseEntity.ok(new ErrorResponse("Cliente eliminado correctamente"));
    }
}
