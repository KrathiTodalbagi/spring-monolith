package com.example.employeeservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@OpenAPIDefinition(
		info = @Info(
				title = "Employee Service API Specifications",
				description = "Employee Service REST APIs Documentation",
				version = "v1.0"
		)
)
@SpringBootApplication
@EnableFeignClients
public class EmployeeServiceApplication {

	@Bean
	public RestClient restClient() {
		return RestClient.builder().build();
	}

	static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
