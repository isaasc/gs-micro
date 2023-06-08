package com.fiap.microgs.repository;

import com.fiap.microgs.model.HistoricoVoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoVooRepository extends JpaRepository<HistoricoVoo, Long> {
}
