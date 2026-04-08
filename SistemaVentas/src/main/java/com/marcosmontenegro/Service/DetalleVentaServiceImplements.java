package com.marcosmontenegro.Service;

import com.marcosmontenegro.Entity.DetalleVenta;
import com.marcosmontenegro.Repository.DetalleVentaRepository;
import com.marcosmontenegro.Repository.ProductoRepository;
import com.marcosmontenegro.Repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DetalleVentaServiceImplements implements DetalleVentaService {

    @Autowired
    private DetalleVentaRepository repository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private VentaRepository ventaRepository;

    @Override
    public List<DetalleVenta> getAllDetalles() { 
        return repository.findAll(); 
    }

    @Override
    public DetalleVenta getDetalleById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Detalle no encontrado"));
    }

    @Override
    public DetalleVenta saveDetalle(DetalleVenta d) {
        cargarRelaciones(d);
        return repository.save(d);
    }

    @Override
    public DetalleVenta updateDetalle(Integer id, DetalleVenta datos) {
        DetalleVenta d = getDetalleById(id);
        cargarRelaciones(datos);
        d.setCantidad(datos.getCantidad());
        d.setPrecioUnitario(datos.getPrecioUnitario());
        d.setSubtotal(datos.getSubtotal());
        d.setProducto(datos.getProducto());
        d.setVenta(datos.getVenta());
        return repository.save(d);
    }

    @Override
    public void deleteDetalle(Integer id) {
        if (!repository.existsById(id)) throw new RuntimeException("Detalle no existe");
        repository.deleteById(id);
    }

    private void cargarRelaciones(DetalleVenta d) {
        d.setProducto(productoRepository.findById(d.getProducto().getId())
            .orElseThrow(() -> new RuntimeException("Producto no existe")));
        d.setVenta(ventaRepository.findById(d.getVenta().getId())
            .orElseThrow(() -> new RuntimeException("Venta no existe")));
    }
}