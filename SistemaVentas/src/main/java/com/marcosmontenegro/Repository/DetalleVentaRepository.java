package com.marcosmontenegro.Repository;

import com.marcosmontenegro.Entity.DetalleVenta;
import com.marcosmontenegro.Entity.Producto;
import com.marcosmontenegro.Entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Integer> {
    
    boolean existsByCantidadAndPrecioUnitarioAndSubtotalAndProductoAndVenta(
            Integer cantidad, 
            Double precioUnitario, 
            Double subtotal, 
            Producto producto, 
            Venta venta
    );
}