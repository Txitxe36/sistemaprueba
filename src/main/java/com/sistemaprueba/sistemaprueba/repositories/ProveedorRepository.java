package com.sistemaprueba.sistemaprueba.repositories;

import com.sistemaprueba.sistemaprueba.entities.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor,Long> {
}
