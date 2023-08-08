package com.sistemaprueba.sistemaprueba.repositories;

import com.sistemaprueba.sistemaprueba.entities.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada,Long> {
}
