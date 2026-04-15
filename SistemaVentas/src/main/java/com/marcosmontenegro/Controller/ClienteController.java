package com.marcosmontenegro.Controller;

import com.marcosmontenegro.Entity.Cliente;
import com.marcosmontenegro.Entity.Usuario;
import com.marcosmontenegro.Service.ClienteService;
import com.marcosmontenegro.Service.UsuarioService;
import com.marcosmontenegro.Exception.ErrorResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping("/clientes")
    public String listarClientes(Model model) {
        List<Cliente> lista = service.getAllClientes();
        model.addAttribute("clientes", lista);
        return "clientes";
    }

    @GetMapping("/clientes/agregarcliente")
    public String formularioNuevo(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "agregarcliente";
    }

    @PostMapping("/clientes/guardarcliente")
    public String guardarCliente(@ModelAttribute Cliente cliente) {
        service.saveCliente(cliente);
        return "redirect:/clientes";
    }
    

    @GetMapping("/clientes/editarcliente/{id}")
    public String formularioEditar(@PathVariable Integer id, Model model) {
        Cliente cliente = service.getClienteById(id);
        model.addAttribute("cliente", cliente);
        return "editarcliente"; 
    }

    @GetMapping("/clientes/eliminar/{id}")
    public String eliminarCliente(@PathVariable Integer id) {
        service.deleteCliente(id);
        return "redirect:/clientes";
    }

}


