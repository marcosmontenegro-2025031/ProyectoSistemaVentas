package com.marcosmontenegro.Service;

import com.marcosmontenegro.Entity.Usuario;
import java.util.List;

public interface UsuarioService {

    List<Usuario> getAllUsuarios();

    Usuario getUsuarioById(Integer id);

    Usuario saveUsuario(Usuario usuario);

    Usuario updateUsuario(Integer id, Usuario usuario);

    void deleteUsuario(Integer id);

    boolean validarLogin(String correo, String password);

    Usuario buscarPorCorreo(String correo);
}