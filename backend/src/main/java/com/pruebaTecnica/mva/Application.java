package com.pruebaTecnica.mva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		System.out.println("Server on port localhost:8080");
		System.out.println("Cuentas = localhost:8080/api/cuentas");
	}

}
