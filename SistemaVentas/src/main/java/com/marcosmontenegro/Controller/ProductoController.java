package com.marcosmontenegro.Controller;

import com.marcosmontenegro.Entity.Producto;
import com.marcosmontenegro.Exception.ErrorResponse;
import com.marcosmontenegro.Service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService service;

    @GetMapping
    public List<Producto> getAll() {
        return service.getAllProductos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getProductoById(id));
    }

    @PostMapping
    public ResponseEntity<Producto> save(@Valid @RequestBody Producto producto) {
        return ResponseEntity.ok(service.saveProducto(producto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> update(@PathVariable Integer id, @Valid @RequestBody Producto producto) {
        return ResponseEntity.ok(service.updateProducto(id, producto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ErrorResponse> delete(@PathVariable Integer id) {
    service.deleteProducto(id);
    return ResponseEntity.ok(new ErrorResponse("Cliente eliminado correctamente"));
    }
}
