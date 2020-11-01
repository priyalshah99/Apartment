package com.apartment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@ComponentScan
@EnableJpaRepositories
@EnableTransactionManagement
public class ApartmentBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApartmentBackendApplication.class, args);
		
		
	}
	@GetMapping("/welcome")
	public String Welcome()
	{
		return "Welcome to admin";
		
	}

}
