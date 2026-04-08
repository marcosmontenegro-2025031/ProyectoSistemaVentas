package com.marcosmontenegro.Service;

import com.marcosmontenegro.Entity.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClienteService {

    List<Cliente> getAllClientes();

    Cliente getClienteById(Integer id);

    Cliente saveCliente(Cliente cliente);

    Cliente updateCliente(Integer id, Cliente cliente);

    void deleteCliente(Integer id);
    
}