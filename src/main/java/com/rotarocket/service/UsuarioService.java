package com.rotarocket.service;

import com.rotarocket.model.Usuario;
import com.rotarocket.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import net.bytebuddy.asm.Advice.Thrown;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UsuarioService {

  private final UsuarioRepository repository;

  public Usuario login(String login, String senha) {
    Usuario usuario = repository.findByLoginAndSenha(login, senha);

     return usuario;

  }




}
