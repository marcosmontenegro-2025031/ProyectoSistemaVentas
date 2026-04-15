package com.marcosmontenegro.Repository;

import com.marcosmontenegro.Entity.Cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
    boolean existsByNombreAndApellidoAndDireccion(
            String nombre, 
            String apellido, 
            String direccion
    );


}
