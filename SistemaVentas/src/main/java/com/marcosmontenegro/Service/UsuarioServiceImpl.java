package com.marcosmontenegro.Service;

import com.marcosmontenegro.Entity.Usuario;
import com.marcosmontenegro.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public List<Usuario> getAllUsuarios() {
        return repository.findAll();
    }

    @Override
    public Usuario getUsuarioById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        boolean existe = repository.existsByUsernameAndEmailAndRolAndEstado(
                usuario.getUsername(),
                usuario.getEmail(),
                usuario.getRol(),
                usuario.getEstado());

        if (existe) {
            throw new RuntimeException("El usuario ya existe.");
        }

        return repository.save(usuario); 
    }

    @Override
    public Usuario updateUsuario(Integer id, Usuario actualizado) {
        Usuario existente = getUsuarioById(id);

        existente.setUsername(actualizado.getUsername());
        existente.setEmail(actualizado.getEmail());
        existente.setRol(actualizado.getRol());
        existente.setEstado(actualizado.getEstado());

        if (actualizado.getPassword() != null && !actualizado.getPassword().isEmpty()) {
            existente.setPassword(actualizado.getPassword());
        }

        return repository.save(existente);
    }

    @Override
    public void deleteUsuario(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Usuario no existe");
        }
        repository.deleteById(id);
    }

    @Override
    public boolean validarLogin(String correo, String password) {
        Usuario usuario = buscarPorCorreo(correo);

        if (usuario != null) {
            return usuario.getPassword().equals(password);
        }

        return false;
    }

    @Override
    public Usuario buscarPorCorreo(String correo) {
        return repository.findByEmail(correo).orElse(null);
    }
}