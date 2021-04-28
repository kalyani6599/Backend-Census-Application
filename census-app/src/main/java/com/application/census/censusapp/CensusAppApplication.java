package com.application.census.censusapp;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.function.Predicate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = "com.application.census")
@EntityScan(basePackages = "com.application.census.entity")
@EnableJpaRepositories(basePackages = "com.application.census.repository")
@EnableSwagger2
@EnableOpenApi
public class CensusAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CensusAppApplication.class, args);
	}
	
	/**
	 * Open api employee store.
	 *
	 * @return the docket
	 */
	@Bean
    public Docket openApiEmployeeStore() {
      return new Docket(DocumentationType.OAS_30)
          .groupName("open-api-census")
          .select()
          .paths(CensusPaths())
          .build();
    }
    
    /**
     * TLTA paths.
     *
     * @return the predicate
     */
    private Predicate<String> CensusPaths() {
      return regex(".*/api/.*");
    }

}
