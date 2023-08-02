package com.sistemaprueba.sistemaprueba.controllers.repositories;

import com.sistemaprueba.sistemaprueba.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long>{
//public interface ClienteRepository extends BaseRepository<Cliente,Long> {
}
