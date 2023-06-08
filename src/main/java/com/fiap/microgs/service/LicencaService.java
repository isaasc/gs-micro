package com.fiap.microgs.service;

import com.fiap.microgs.model.Drone;
import com.fiap.microgs.model.LicencaVoo;
import com.fiap.microgs.repository.DroneRepository;
import com.fiap.microgs.repository.LicencaVooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LicencaService {

    @Autowired
    private LicencaVooRepository licencaRepository;

    public List<LicencaVoo> findAll() {
        return licencaRepository.findAll();
    }

    public void save(LicencaVoo licencaVoo) {
        this.licencaRepository.save(licencaVoo);
    }

    public LicencaVoo findById(Long id) {
        Optional<LicencaVoo> licencaVooOptional = licencaRepository.findById(id);
        LicencaVoo licencaVoo = null;
        if (licencaVooOptional.isPresent()) {
            licencaVoo = licencaVooOptional.get();
        } else {
            throw new RuntimeException("Licenca not found for this id: " + id);
        }
        return licencaVoo;
    }

    public void deleteById(Long id) {
        this.licencaRepository.deleteById(id);
    }

}
