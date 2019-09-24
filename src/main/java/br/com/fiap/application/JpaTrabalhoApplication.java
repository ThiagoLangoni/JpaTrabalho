package br.com.fiap.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.com.fiap")
public class JpaTrabalhoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaTrabalhoApplication.class, args);
	}

}
