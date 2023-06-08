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
@RequestMapping("/drone")
public class DroneController {

    @Autowired
    private DroneService droneService;

    @Autowired
    private LicencaService licencaService;

    @Autowired
    private HistoricoService historicoService;

    @GetMapping("")
    public ModelAndView getAllDrones() {
        ModelAndView model = new ModelAndView("drone/list");
        List<Drone> dronesList = droneService.findAll();
        List<LicencaVoo> licencasVooList = licencaService.findAll();
        List<HistoricoVoo> historicoVooListList = historicoService.findAll();
        model.addObject("drones", dronesList);
        model.addObject("licencas", licencasVooList);
        model.addObject("historicos", historicoVooListList);
        return model;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView model = new ModelAndView("drone/create");
        List<LicencaVoo> licencaVoos = licencaService.findAll();
        model.addObject("licencas", licencaVoos);
        return model;
    }

    @PostMapping("/create")
    public ResponseEntity<Drone> create(@Valid @RequestBody Drone drone) {
        droneService.save(drone);
        return new ResponseEntity<Drone>(drone, HttpStatus.CREATED);
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        Drone drone = droneService.findById(id);
        ModelAndView modelAndView = new ModelAndView("drone/edit");
        modelAndView.addObject("drone", drone);
        List<LicencaVoo> licencaVoos = licencaService.findAll();
        modelAndView.addObject("licencas", licencaVoos);
        return modelAndView;
    }

    @PostMapping("/update")
    public RedirectView update(@ModelAttribute("drone") Drone drone) {
        droneService.save(drone);
        return new RedirectView("/drone");
    }

    @GetMapping("/delete/{id}")
    public RedirectView delete(@PathVariable(value = "id") Long id) {
        droneService.deleteById(id);
        return new RedirectView("/drone");
    }
}
