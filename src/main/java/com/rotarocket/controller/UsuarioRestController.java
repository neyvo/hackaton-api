package com.rotarocket.controller;

import com.rotarocket.model.Favorito;
import com.rotarocket.model.Usuario;
import com.rotarocket.model.UsuarioInput;
import com.rotarocket.repository.FavoritoRepository;
import com.rotarocket.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/usuarios")
public class UsuarioRestController {

    private final UsuarioRepository repository;
    private final FavoritoRepository favoritoRepository;

    @GetMapping
    public List<Usuario> buscarListaUsuarios() {

        return repository.findAll();
    }

    @PostMapping
    public Usuario cadastrarUsuario(UsuarioInput usuarioInput) {

        Usuario usuario = Usuario.criar(usuarioInput.getNome(), usuarioInput.getLogin(), usuarioInput.getSenha());
        return repository.saveAndFlush(usuario);
    }

    @GetMapping("/login")
    public Usuario login(UsuarioInput usuarioInput) {

        return repository.findByLoginAndSenha(usuarioInput.getLogin(), usuarioInput.getSenha());
    }

    @GetMapping("/{usuarioId}/favoritos")
    public List<Favorito> favoritos(@PathParam("usuarioId") Long usuarioId) {

        return favoritoRepository.findByUsuarioId(usuarioId);
    }

}
