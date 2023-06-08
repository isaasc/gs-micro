package com.fiap.microgs.service;

import com.fiap.microgs.model.HistoricoVoo;
import com.fiap.microgs.repository.HistoricoVooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoricoService {

    @Autowired
    private HistoricoVooRepository historicoVooRepository;

    public List<HistoricoVoo> findAll() {
        return historicoVooRepository.findAll();
    }

    public void save(HistoricoVoo historicoVoo) {
        this.historicoVooRepository.save(historicoVoo);
    }

    public HistoricoVoo findById(Long id) {
        Optional<HistoricoVoo> historicoVooOptional = historicoVooRepository.findById(id);
        HistoricoVoo historicoVoo = null;
        if (historicoVooOptional.isPresent()) {
            historicoVoo = historicoVooOptional.get();
        } else {
            throw new RuntimeException("Historico not found for this id: " + id);
        }
        return historicoVoo;
    }

    public void deleteById(Long id) {
        this.historicoVooRepository.deleteById(id);
    }

}
