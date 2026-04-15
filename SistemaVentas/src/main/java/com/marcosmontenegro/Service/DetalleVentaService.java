package com.marcosmontenegro.Service;

import com.marcosmontenegro.Entity.DetalleVenta;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface DetalleVentaService {

    List<DetalleVenta> getAllDetalleVentas();

    DetalleVenta getDetalleVentaById(Integer id);

    void saveDetalleVenta(DetalleVenta detalleVenta);
    
    void deleteDetalleVenta(Integer id);
    
}