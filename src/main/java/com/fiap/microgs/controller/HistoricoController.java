package com.fiap.microgs.controller;

import com.fiap.microgs.model.Drone;
import com.fiap.microgs.model.HistoricoVoo;
import com.fiap.microgs.model.LicencaVoo;
import com.fiap.microgs.service.DroneService;
import com.fiap.microgs.service.HistoricoService;
import com.fiap.microgs.service.LicencaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/historico")
public class HistoricoController {

    @Autowired
    private HistoricoService historicoService;

    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("historico/create");
    }

    @PostMapping("/create")
    public ResponseEntity<HistoricoVoo> create(@Valid @RequestBody HistoricoVoo historicoVoo) {
        historicoService.save(historicoVoo);
        return new ResponseEntity<HistoricoVoo>(historicoVoo, HttpStatus.CREATED);
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        HistoricoVoo historicoVoo = historicoService.findById(id);
        ModelAndView modelAndView = new ModelAndView("historico/edit");
        modelAndView.addObject("historico", historicoVoo);
        return modelAndView;
    }

    @PostMapping("/update")
    public RedirectView update(@ModelAttribute("historico") HistoricoVoo historico) {
        historicoService.save(historico);
        return new RedirectView("/drone");
    }

    @GetMapping("/delete/{id}")
    public RedirectView delete(@PathVariable(value = "id") Long id) {
        historicoService.deleteById(id);
        return new RedirectView("/drone");
    }
}
