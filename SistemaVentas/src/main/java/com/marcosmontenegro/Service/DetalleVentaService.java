package com.marcosmontenegro.Service;

import com.marcosmontenegro.Entity.DetalleVenta;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface DetalleVentaService {

    List<DetalleVenta> getAllDetalles();

    DetalleVenta getDetalleById(Integer id);

    DetalleVenta saveDetalle(DetalleVenta detalle);

    DetalleVenta updateDetalle(Integer id, DetalleVenta detalle);

    void deleteDetalle(Integer id);
    
}