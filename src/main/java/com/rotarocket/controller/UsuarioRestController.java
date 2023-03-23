package com.rotarocket.controller;

import com.rotarocket.model.Favorito;
import com.rotarocket.model.Usuario;
import com.rotarocket.model.UsuarioInput;
import com.rotarocket.repository.FavoritoRepository;
import com.rotarocket.repository.UsuarioRepository;
import com.rotarocket.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;
import org.springframework.web.server.ResponseStatusException;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/usuarios")
public class UsuarioRestController {

    private final UsuarioRepository repository;
    private final UsuarioService service;
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

    @PostMapping("/login")
    public Usuario login(@RequestParam String login, @RequestParam String senha)  {

        var usuario = service.login(login, senha);
        if(usuario == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Usuario ou senha não encontrados", new Exception());
        }
        return usuario;
    }

    @GetMapping("/{usuarioId}/favoritos")
    public List<Favorito> favoritos(@PathParam("usuarioId") Long usuarioId) {

        return favoritoRepository.findByUsuarioId(usuarioId);
    }

}
