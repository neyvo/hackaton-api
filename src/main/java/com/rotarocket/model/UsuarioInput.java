package com.rotarocket.model;

import lombok.*;

import javax.persistence.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class UsuarioInput {

    private Long id;
    private String nome;
    private String login;
    private String senha;
}
