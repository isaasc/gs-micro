package com.fiap.microgs.service;

import com.fiap.microgs.model.Usuario;
import com.fiap.microgs.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void save(Usuario usuario) {
        this.usuarioRepository.save(usuario);
    }

    public Usuario findById(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        Usuario usuario = null;
        if (usuarioOptional.isPresent()) {
            usuario = usuarioOptional.get();
        } else {
            throw new RuntimeException("Usuario not found for this id: " + id);
        }
        return usuario;
    }
}
