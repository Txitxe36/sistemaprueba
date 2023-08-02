package com.sistemaprueba.sistemaprueba.controllers.repositories;

import com.sistemaprueba.sistemaprueba.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
