package com.rotarocket.repository;

import com.rotarocket.model.Favorito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoritoRepository extends JpaRepository<Favorito, Long> {

    public List<Favorito> findByUsuarioId(Long usuarioId);

}

