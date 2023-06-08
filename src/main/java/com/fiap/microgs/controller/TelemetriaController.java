package com.fiap.microgs.controller;

import com.fiap.microgs.model.Drone;
import com.fiap.microgs.model.HistoricoVoo;
import com.fiap.microgs.model.LicencaVoo;
import com.fiap.microgs.model.Telemetria;
import com.fiap.microgs.service.DroneService;
import com.fiap.microgs.service.HistoricoService;
import com.fiap.microgs.service.LicencaService;
import com.fiap.microgs.service.TelemetriaService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/telemetria")
public class TelemetriaController {

    @Autowired
    private TelemetriaService telemetriaService;

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
