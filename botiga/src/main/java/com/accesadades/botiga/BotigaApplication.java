package com.accesadades.botiga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // Habilita l'auditoria JPA, per gestionar les dates automàticament

public class BotigaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BotigaApplication.class, args);
	}

}
