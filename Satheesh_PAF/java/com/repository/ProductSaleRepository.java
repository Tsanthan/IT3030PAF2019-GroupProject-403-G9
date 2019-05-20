package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.model.ProductSaleModel;

public interface ProductSaleRepository extends JpaRepository<ProductSaleModel, Long> {
}
