package com.sistemaprueba.sistemaprueba.repositories;

import com.sistemaprueba.sistemaprueba.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol,Long> {
}
