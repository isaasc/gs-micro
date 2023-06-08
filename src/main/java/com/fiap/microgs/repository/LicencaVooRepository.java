package com.fiap.microgs.repository;

import com.fiap.microgs.model.LicencaVoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicencaVooRepository extends JpaRepository<LicencaVoo, Long> {
}
