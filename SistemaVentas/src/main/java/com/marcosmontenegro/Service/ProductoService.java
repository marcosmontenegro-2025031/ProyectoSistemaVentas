package com.marcosmontenegro.Service;

import com.marcosmontenegro.Entity.Producto;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ProductoService {

    List<Producto> getAllProductos();

    Producto getProductoById(Integer id);

    Producto saveProducto(Producto producto);

    Producto updateProducto(Integer id, Producto producto);

    void deleteProducto(Integer id);
    
}