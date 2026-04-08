package com.marcosmontenegro.Repository;

import com.marcosmontenegro.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    
    boolean existsByNombreAndPrecioAndStockAndEstado(
            String nombre, 
            Double precio, 
            Integer stock, 
            Integer estado
    );
}