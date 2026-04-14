package com.marcosmontenegro.Service;

import com.marcosmontenegro.Entity.Cliente;
import com.marcosmontenegro.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImplements implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    public List<Cliente> getAllClientes() {
        return repository.findAll();
    }

    @Override
    public Cliente getClienteById(Integer id) {
        Optional<Cliente> resultado = repository.findById(id);
        if (resultado.isPresent()) {
            return resultado.get();
        } else {
            throw new RuntimeException("Cliente no encontrado con el ID: " + id);
        }
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        boolean existe = repository.existsByNombreAndApellidoAndDireccion(
                cliente.getNombre(), 
                cliente.getApellido(), 
                cliente.getDireccion()
        );

        if (existe) {
            throw new RuntimeException("El cliente ya existe en el sistema.");
        }
        
        return repository.save(cliente);
    }

    @Override
    public Cliente updateCliente(Integer id, Cliente actualizado) {
        Optional<Cliente> resultado = repository.findById(id);
        
        if (resultado.isPresent()) {
            Cliente clienteExistente = resultado.get();
            clienteExistente.setNombre(actualizado.getNombre());
            clienteExistente.setApellido(actualizado.getApellido());
            clienteExistente.setDireccion(actualizado.getDireccion());
            clienteExistente.setEstado(actualizado.getEstado());

            return repository.save(clienteExistente);
        } else {
            throw new RuntimeException("No se puede actualizar: El cliente con ID " + id + " no existe.");
        }
    }

    @Override
    public void deleteCliente(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("No se puede deleteUsuario: El cliente con ID " + id + " no existe.");
        }
    }
}
