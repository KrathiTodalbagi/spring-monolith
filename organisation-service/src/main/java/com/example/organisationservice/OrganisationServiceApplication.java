package com.example.organisationservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(
		info = @Info(
				title = "Organisation Service API Specifications",
				version = "v1.0"
		)
)
@SpringBootApplication
public class OrganisationServiceApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	static void main(String[] args) {
		SpringApplication.run(OrganisationServiceApplication.class, args);
	}
}
