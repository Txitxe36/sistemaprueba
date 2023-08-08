package com.sistemaprueba.sistemaprueba.repositories;

import com.sistemaprueba.sistemaprueba.entities.DetalleTemporal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleTemporalRepository extends JpaRepository<DetalleTemporal,Long> {
}
