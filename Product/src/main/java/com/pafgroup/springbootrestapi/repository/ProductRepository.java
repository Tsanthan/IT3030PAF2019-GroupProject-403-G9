package com.pafgroup.springbootrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.pafgroup.springbootrestapi.model.Product; 

public interface ProductRepository extends JpaRepository<Product, Long> {

}
