package com.fiap.microgs.controller;

import com.fiap.microgs.model.LicencaVoo;
import com.fiap.microgs.model.Usuario;
import com.fiap.microgs.service.LicencaService;
import com.fiap.microgs.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("usuario/login");
    }

    @PostMapping("/create")
    public ResponseEntity<Usuario> create(@Valid @RequestBody Usuario usuario) {
        usuarioService.save(usuario);
        return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);
    }

    @GetMapping("/login/{role}")
    public RedirectView redirect(Model model, @PathVariable("role") String role) {
        if (role.equals("drone-seed")) {
            return new RedirectView("/drone");
        } else if (role.equals("telemetria-reader")) {
            return new RedirectView("/drone/visualize");
        } else if (role.equals("drone-admin")) {
            return new RedirectView("/drone");
        } else {
            return new RedirectView("/drone");
        }
    }
}
