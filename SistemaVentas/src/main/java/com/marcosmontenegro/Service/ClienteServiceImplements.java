package com.marcosmontenegro.Service;

import com.marcosmontenegro.Entity.Cliente;
import com.marcosmontenegro.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImplements implements ClienteService {

    @Autowired
    private ClienteRepository repo;

    @Override
    public List<Cliente> getAllClientes() {
        return repo.findAll();
    }

    @Override
    public Cliente getClienteById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void saveCliente(Cliente cliente) {
        repo.save(cliente);
    }

    @Override
    public void deleteCliente(Integer id) {
        repo.deleteById(id);
    }

}
