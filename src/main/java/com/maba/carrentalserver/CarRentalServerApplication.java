package com.maba.carrentalserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
public class CarRentalServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarRentalServerApplication.class, args);
	}

}
