package com.rotarocket.model;

import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class FavoritoInput {

    private Long id;
    private Long usuarioId;
    private String titulo;
    private String endereco;
    private String latitude;
    private String longitude;
}
