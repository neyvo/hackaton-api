package com.rotarocket.controller;

import com.rotarocket.model.Favorito;
import com.rotarocket.model.FavoritoInput;
import com.rotarocket.model.Usuario;
import com.rotarocket.model.UsuarioInput;
import com.rotarocket.repository.FavoritoRepository;
import com.rotarocket.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/favoritos")
public class FavoritoRestController {

    private final FavoritoRepository repository;

    @GetMapping
    public List<Favorito> buscarListaFavoritos() {

        return repository.findAll();
    }

    @PostMapping
    public Favorito cadastrarFavorito(FavoritoInput input) {

        Favorito favorito = Favorito.criar(input.getUsuarioId(), input.getTitulo(), input.getEndereco(), input.getLatitude(), input.getLongitude() );
        return repository.saveAndFlush(favorito);
    }


}
