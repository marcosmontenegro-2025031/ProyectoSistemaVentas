package com.marcosmontenegro.Service;

import com.marcosmontenegro.Entity.DetalleVenta;
import com.marcosmontenegro.Repository.DetalleVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DetalleVentaServiceImplements implements DetalleVentaService {

    @Autowired
    private DetalleVentaRepository repo;

    @Override
    public List<DetalleVenta> getAllDetalleVentas() {
        return repo.findAll();
    }

    @Override
    public DetalleVenta getDetalleVentaById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void saveDetalleVenta(DetalleVenta detalleVenta) {
        repo.save(detalleVenta);
    }

    @Override
    public void deleteDetalleVenta(Integer id) {
        repo.deleteById(id);
    }
}