package com.marcosmontenegro.Controller;

import com.marcosmontenegro.Entity.Usuario;
import com.marcosmontenegro.Exception.ErrorResponse;
import com.marcosmontenegro.Service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<Usuario> getAll() {
        return service.getAllUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getUsuarioById(id));
    }

    @PostMapping
    public ResponseEntity<Usuario> save(@Valid @RequestBody Usuario usuario) {
        return ResponseEntity.ok(service.saveUsuario(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Integer id, @Valid @RequestBody Usuario usuario) {
        return ResponseEntity.ok(service.updateUsuario(id, usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ErrorResponse> delete(@PathVariable Integer id) {
        service.deleteUsuario(id);
        return ResponseEntity.ok(new ErrorResponse("Usuario eliminado correctamente"));
    }
}