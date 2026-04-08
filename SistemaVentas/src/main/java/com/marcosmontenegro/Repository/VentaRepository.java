package com.marcosmontenegro.Repository;

import com.marcosmontenegro.Entity.Cliente;
import com.marcosmontenegro.Entity.Usuario;
import com.marcosmontenegro.Entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {
    
    boolean existsByFechaVentaAndTotalAndEstadoAndClienteAndUsuario(
            LocalDate fechaVenta, 
            Double total, 
            Integer estado, 
            Cliente cliente, 
            Usuario usuario
    );
}