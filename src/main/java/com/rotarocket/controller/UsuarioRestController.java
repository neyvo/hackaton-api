package com.rotarocket.controller;

import com.rotarocket.model.Usuario;
import com.rotarocket.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/usuarios")
public class UsuarioRestController {

    private final UsuarioRepository repository;
    @GetMapping
    public List<Usuario> buscarListaUsuarios() {

        return repository.findAll();
    }
}
