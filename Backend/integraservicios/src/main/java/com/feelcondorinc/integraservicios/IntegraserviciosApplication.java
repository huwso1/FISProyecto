package com.feelcondorinc.integraservicios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class IntegraserviciosApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegraserviciosApplication.class, args);
	}

}
