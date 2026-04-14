package com.marcosmontenegro.Service;

import com.marcosmontenegro.Entity.Producto;
import com.marcosmontenegro.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImplements implements ProductoService {

    @Autowired
    private ProductoRepository repository;

    @Override
    public List<Producto> getAllProductos() {
        return repository.findAll();
    }

    @Override
    public Producto getProductoById(Integer id) {
        Optional<Producto> resultado = repository.findById(id);
        if (resultado.isPresent()) {
            return resultado.get();
        } else {
            throw new RuntimeException("Producto no encontrado con ID: " + id);
        }
    }

    @Override
    public Producto saveProducto(Producto producto) {
        boolean existe = repository.existsByNombreAndPrecioAndStockAndEstado(
                producto.getNombre(),
                producto.getPrecio(),
                producto.getStock(),
                producto.getEstado()
        );

        if (existe) {
            throw new RuntimeException("El producto ya existe con estos datos.");
        }

        return repository.save(producto);
    }

    @Override
    public Producto updateProducto(Integer id, Producto actualizado) {
        Optional<Producto> resultado = repository.findById(id);

        if (resultado.isPresent()) {
            Producto existente = resultado.get();

            existente.setNombre(actualizado.getNombre());
            existente.setPrecio(actualizado.getPrecio());
            existente.setStock(actualizado.getStock());
            existente.setEstado(actualizado.getEstado());

            return repository.save(existente);
        } else {
            throw new RuntimeException("No se puede actualizar: El producto no existe.");
        }
    }

    @Override
    public void deleteProducto(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("No se puede deleteUsuario: El producto no existe.");
        }
    }
}