package com.noxilaman.carcareshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CarcareshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarcareshopApplication.class, args);
	}

}
