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
    private VentaRepository repository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Venta> getAllVentas() {
        return repository.findAll();
    }

    @Override
    public Venta getVentaById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada con ID: " + id));
    }

    @Override
    public Venta saveVenta(Venta venta) {
        validarRelaciones(venta);
        if (repository.existsByFechaVentaAndTotalAndEstadoAndClienteAndUsuario(
                venta.getFechaVenta(), venta.getTotal(), venta.getEstado(), venta.getCliente(), venta.getUsuario())) {
            throw new RuntimeException("La venta ya existe");
        }
        return repository.save(venta);
    }

    @Override
    public Venta updateVenta(Integer id, Venta datos) {
        Venta v = getVentaById(id); // Si no existe, lanza excepción
        
        validarRelaciones(datos); // Buscamos cliente y usuario nuevos
        
        v.setFechaVenta(datos.getFechaVenta());
        v.setTotal(datos.getTotal());
        v.setEstado(datos.getEstado());
        v.setCliente(datos.getCliente());
        v.setUsuario(datos.getUsuario());

        return repository.save(v);
    }

    @Override
    public void deleteVenta(Integer id) {
        if (!repository.existsById(id)) throw new RuntimeException("Venta no existe");
        repository.deleteById(id);
    }

    private void validarRelaciones(Venta venta) {
        Cliente c = clienteRepository.findById(venta.getCliente().getId())
                .orElseThrow(() -> new RuntimeException("Cliente no existe"));
        Usuario u = usuarioRepository.findById(venta.getUsuario().getId())
                .orElseThrow(() -> new RuntimeException("Usuario no existe"));
        venta.setCliente(c);
        venta.setUsuario(u);
    }
}