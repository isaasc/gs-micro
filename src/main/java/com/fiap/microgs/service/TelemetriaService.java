package com.fiap.microgs.service;

import com.fiap.microgs.model.Telemetria;
import com.fiap.microgs.repository.TelemetriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
