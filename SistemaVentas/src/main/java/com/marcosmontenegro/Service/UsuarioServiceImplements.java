package com.marcosmontenegro.Service;

import com.marcosmontenegro.Entity.Usuario;
import com.marcosmontenegro.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UsuarioServiceImplements implements UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    @Override
    public Usuario registrar(String username, String password) {
        if (repo.findByUsername(username) != null) {
            return null;
        }
        Usuario u = new Usuario();
        u.setUsername(username);
        u.setPassword(password);
        return repo.save(u);
    }

    @Override
    public Usuario login(String username, String password) {
        Usuario u = repo.findByUsername(username);
        if (u != null && u.getPassword().equals(password)) {
            return u;
        }
        return null;
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return repo.findAll();
    }

    @Override
    public void deleteUsuario(Integer id) {
        repo.deleteById(id);
    }
}
