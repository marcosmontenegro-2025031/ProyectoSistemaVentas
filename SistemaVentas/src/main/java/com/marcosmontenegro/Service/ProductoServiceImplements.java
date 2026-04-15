package com.marcosmontenegro.Service;

import com.marcosmontenegro.Entity.Producto;
import com.marcosmontenegro.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImplements implements ProductoService {

    @Autowired
    private ProductoRepository repo;

    @Override
    public List<Producto> getAllProductos() {
        return repo.findAll();
    }

    @Override
    public Producto getProductoById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void saveProducto(Producto producto) {
        repo.save(producto);
    }

    @Override
    public void deleteProducto(Integer id) {
        repo.deleteById(id);
    }
}