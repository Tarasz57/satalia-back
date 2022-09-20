package com.satalia.beer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class BeerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeerApplication.class, args);
	}

}
