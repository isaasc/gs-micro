package com.fiap.microgs.service;

import com.fiap.microgs.model.Drone;
import com.fiap.microgs.repository.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DroneService {

    @Autowired
    private DroneRepository droneRepository;

    public List<Drone> findAll() {
        return droneRepository.findAll();
    }

    public void save(Drone drone) {
        this.droneRepository.save(drone);
    }

    public Drone findById(Long id) {
        Optional<Drone> droneOptional = droneRepository.findById(id);
        Drone drone = null;
        if (droneOptional.isPresent()) {
            drone = droneOptional.get();
        } else {
            throw new RuntimeException("Drone not found for this id: " + id);
        }
        return drone;
    }

    public void deleteById(Long id) {
        this.droneRepository.deleteById(id);
    }

}
