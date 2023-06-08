package com.fiap.microgs.controller;

import com.fiap.microgs.model.Drone;
import com.fiap.microgs.model.LicencaVoo;
import com.fiap.microgs.service.DroneService;
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
@RequestMapping("/licenca")
public class LicencaController {

    @Autowired
    private LicencaService licencaService;

    @Autowired
    private DroneService droneService;

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView model = new ModelAndView("licenca/create");
        List<Drone> drones = droneService.findAll();
        model.addObject("drones", drones);
        return model;
    }

    @PostMapping("/create")
    public ResponseEntity<LicencaVoo> create(@Valid @RequestBody LicencaVoo licencaVoo) {
        licencaService.save(licencaVoo);
        return new ResponseEntity<LicencaVoo>(licencaVoo, HttpStatus.CREATED);
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        LicencaVoo licenca = licencaService.findById(id);
        ModelAndView modelAndView = new ModelAndView("licenca/edit");
        modelAndView.addObject("licenca", licenca);
        List<Drone> drones = droneService.findAll();
        modelAndView.addObject("drones", drones);
        return modelAndView;
    }

    @PostMapping("/update")
    public RedirectView update(@ModelAttribute("licenca") LicencaVoo licenca) {
        licencaService.save(licenca);
        return new RedirectView("/drone");
    }

    @GetMapping("/delete/{id}")
    public RedirectView delete(@PathVariable(value = "id") Long id) {
        licencaService.deleteById(id);
        return new RedirectView("/drone");
    }

}
