package com.marcosmontenegro.Repository;

import com.marcosmontenegro.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByEmail(String email); // 🔥 IMPORTANTE

    boolean existsByUsernameAndEmailAndRolAndEstado(
            String username,
            String email,
            String rol,
            Integer estado
    );

    Usuario findByUsuario(String usuario);
}