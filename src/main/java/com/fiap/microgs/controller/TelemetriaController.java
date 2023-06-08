package com.fiap.microgs.controller;

import com.fiap.microgs.model.Drone;
import com.fiap.microgs.model.Telemetria;
import com.fiap.microgs.service.DroneService;
import com.fiap.microgs.service.TelemetriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/telemetria")
public class TelemetriaController {

    @Autowired
    private TelemetriaService telemetriaService;

    @Autowired
    private DroneService droneService;

    @GetMapping("")
    public ModelAndView getListView() {
        ModelAndView model = new ModelAndView("telemetria/list");
        List<Telemetria> telemetriaList = telemetriaService.findAll();
        model.addObject("telemetrias", telemetriaList);
        return model;
    }

    @GetMapping("/create")
    public ModelAndView getCreateView() {
        ModelAndView model = new ModelAndView("telemetria/create");
        List<Drone> drones = droneService.findAll();

        model.addObject("drones", drones);
        return model;
    }

    @PostMapping("/create")
    public ResponseEntity<Telemetria> create(@Valid @RequestBody Telemetria telemetria) {
        telemetriaService.save(telemetria);
        return new ResponseEntity<Telemetria>(telemetria, HttpStatus.CREATED);
    }

    @PostMapping("/createTelemetriaList")
    public ResponseEntity<String> createAll(@RequestBody List<Telemetria> telemetriaList) {
        for (Telemetria telemetria: telemetriaList) {
            telemetriaService.save(telemetria);
        }
        return ResponseEntity.ok("Telemetry data received and saved successfully");
    }

}
