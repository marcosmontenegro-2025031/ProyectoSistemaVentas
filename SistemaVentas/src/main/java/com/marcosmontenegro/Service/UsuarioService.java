package com.marcosmontenegro.Service;

import com.marcosmontenegro.Entity.Usuario;
import java.util.List;

public interface UsuarioService {

    List<Usuario> getAllUsuarios();


    Usuario registrar(String username, String password);

    Usuario login(String username, String password);

    void deleteUsuario(Integer id);

}