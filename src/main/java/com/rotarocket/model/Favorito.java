package com.rotarocket.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "favorito")
public class Favorito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id")
    private Long usuarioId;
    private String titulo;
    private String endereco;
    private String latitude;
    private String longitude;

    public static Favorito criar(Long usuarioId, String titulo, String endereco, String latitude, String longitude) {
        return new Favorito(null, usuarioId , titulo, endereco, latitude, longitude );
    }
}
