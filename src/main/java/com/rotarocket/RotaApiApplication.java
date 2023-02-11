package com.rotarocket;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(considerNestedRepositories = true)
@OpenAPIDefinition(info = @Info(title = "Rota API", version = "1.0", description = "Gerenciamento de Rotas"))

public class RotaApiApplication {


	public static void main(String[] args) {

		SpringApplication.run(RotaApiApplication.class, args);

	}

}
