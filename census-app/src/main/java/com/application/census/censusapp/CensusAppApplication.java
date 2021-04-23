package com.application.census.censusapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.application.census")
@EntityScan(basePackages = "com.application.census.entity")
@EnableJpaRepositories(basePackages = "com.application.census.repository")
public class CensusAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CensusAppApplication.class, args);
	}

}
