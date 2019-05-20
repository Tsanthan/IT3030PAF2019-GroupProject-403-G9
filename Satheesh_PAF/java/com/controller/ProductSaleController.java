package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.ResourceNotFoundExceptionClass;
import com.model.ProductSaleModel;
import com.repository.ProductSaleRepository;

@RestController
@RequestMapping("/api")
public class ProductSaleController {

	@Autowired
    ProductSaleRepository productSaleRepository;
	
	// Get All Product Sales
	@GetMapping("/product_sales")
	public List<ProductSaleModel> getAllProductSales() {
	    return productSaleRepository.findAll();
	}
	
	// Sale a new Product Sales
	@PostMapping("/product_sales")
	public ProductSaleModel saleAProductSale(@Valid @RequestBody ProductSaleModel productSale) {
	    return productSaleRepository.save(productSale);
	}
	
	// Get a Single Product Sale
	@GetMapping("/product_sales/{sale_id}")
	public ProductSaleModel getProducSaleById(@PathVariable(value = "sale_id") Long saleID) {
	    return productSaleRepository.findById(saleID)
	            .orElseThrow(() -> new ResourceNotFoundExceptionClass("product_sale", "sale_id", saleID));
	}
	
	// Update a Product Sale
	@PutMapping("/product_sales/{sale_id}")
	public ProductSaleModel updateProductSale(@PathVariable(value = "sale_id") Long saleID,
	                                        @Valid @RequestBody ProductSaleModel productSaleDetails) {
		ProductSaleModel productSales = productSaleRepository.findById(saleID)
				.orElseThrow(() -> new ResourceNotFoundExceptionClass("product_sale", "sale_id", saleID));
	    
		productSales.setFkProductCode(productSales.getFkProductCode());
		productSales.setFkStockID(productSales.getFkStockID());
		productSales.setQuantity(productSales.getQuantity());
		productSales.setAmount(productSales.getAmount());
		productSales.setDiscount(productSales.getDiscount());
		productSales.setNetAmount(productSales.getNetAmount());
		productSales.setDiscount(productSales.getDiscount());
		productSales.setFkInvoiceNo(productSales.getFkInvoiceNo());
		productSales.setStatus(productSales.getStatus());
		productSales.setDateTime(productSales.getDateTime());
		productSales.setFkUserID(productSales.getFkUserID());
		ProductSaleModel productSaleModel = productSaleRepository.save(productSales);
		return productSaleModel;
	}
	
	// Delete a Product Sale
	@DeleteMapping("/product_sales/{sale_id}")
	public ResponseEntity<?> deleteProductSale(@PathVariable(value = "sale_id") Long saleID) {
		ProductSaleModel productSale = productSaleRepository.findById(saleID)
				.orElseThrow(() -> new ResourceNotFoundExceptionClass("product_sale", "sale_id", saleID));
		productSaleRepository.delete(productSale);
	    return ResponseEntity.ok().build();
	}
	
}
