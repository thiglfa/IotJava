package com.example.denuncia_ambiental.repository;

import com.example.denuncia_ambiental.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    //Método para buscar por email
    Optional<Usuario> findByEmail(String email);

    //Método para verificar existência por email
    boolean existsByEmail(String email);
}