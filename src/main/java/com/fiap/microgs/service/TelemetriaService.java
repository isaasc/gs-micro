package com.fiap.microgs.service;

import com.fiap.microgs.model.LicencaVoo;
import com.fiap.microgs.model.Telemetria;
import com.fiap.microgs.repository.LicencaVooRepository;
import com.fiap.microgs.repository.TelemetriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelemetriaService {

    @Autowired
    private TelemetriaRepository telemetriaRepository;

    public List<Telemetria> findAll() {
        return telemetriaRepository.findAll();
    }

    public void save(Telemetria telemetria) {
        this.telemetriaRepository.save(telemetria);
    }

    public Telemetria findById(Long id) {
        Optional<Telemetria> telemetriaOptional = telemetriaRepository.findById(id);
        Telemetria telemetria = null;
        if (telemetriaOptional.isPresent()) {
            telemetria = telemetriaOptional.get();
        } else {
            throw new RuntimeException("Telemetria not found for this id: " + id);
        }
        return telemetria;
    }

    public void deleteById(Long id) {
        this.telemetriaRepository.deleteById(id);
    }

}
