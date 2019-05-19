package com.pafgroup.springbootrestapi;

import java.util.ArrayList; 
import java.util.List; 

import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication; 
import org.springframework.data.jpa.repository.config.EnableJpaAuditing; 
 
import com.pafgroup.springbootrestapi.controller.ProductController; 
import com.pafgroup.springbootrestapi.dao.ProductDAO; 
import com.pafgroup.springbootrestapi.model.Product; 
 
@SpringBootApplication 
@EnableJpaAuditing 

public class ProductApplication {
	public static void main(String args[]) {   
		SpringApplication.run(ProductApplication.class, args);    
		} 

}
