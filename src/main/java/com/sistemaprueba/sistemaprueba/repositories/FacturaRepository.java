package com.sistemaprueba.sistemaprueba.repositories;

import com.sistemaprueba.sistemaprueba.entities.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura,Long> {
}
