package com.pafgroup.springbootrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pafgroup.springbootrestapi.model.ProductType;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {

}
