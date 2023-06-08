package com.fiap.microgs.repository;

import com.fiap.microgs.model.Telemetria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelemetriaRepository extends JpaRepository<Telemetria, Long> {
}
