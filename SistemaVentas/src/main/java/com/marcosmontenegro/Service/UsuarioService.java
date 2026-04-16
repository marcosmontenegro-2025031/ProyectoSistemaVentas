package com.marcosmontenegro.Service;

import com.marcosmontenegro.Entity.Usuario;
import java.util.List;


public interface UsuarioService {

    List<Usuario> getAllUsuarios();

    Usuario getUsuarioById(Integer id);

    Usuario registrar(String username, String password);

    Usuario login(String username, String password);

    void saveUsuario(Usuario usuario);

    void deleteUsuario(Integer id);

    Usuario registrar(String username, String password, String email);

}