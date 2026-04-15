package com.marcosmontenegro.Service;

import com.marcosmontenegro.Entity.Venta;
import com.marcosmontenegro.Entity.Cliente;
import com.marcosmontenegro.Entity.Usuario;
import com.marcosmontenegro.Repository.VentaRepository;
import com.marcosmontenegro.Repository.ClienteRepository;
import com.marcosmontenegro.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VentaServiceImplements implements VentaService {

    @Autowired
    private VentaRepository repo;

    @Override
    public List<Venta> getAllVentas() {
        return repo.findAll();
    }

    @Override
    public Venta getVentaById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void saveVenta(Venta venta) {
        repo.save(venta);
    }

    @Override
    public void deleteVenta(Integer id) {
        repo.deleteById(id);
    }
}