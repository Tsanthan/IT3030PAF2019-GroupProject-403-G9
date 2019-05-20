package com.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class InvoiceApplication {

	public static void main(String args[]) {   
		SpringApplication.run(InvoiceApplication.class, args);    
		} 
}
