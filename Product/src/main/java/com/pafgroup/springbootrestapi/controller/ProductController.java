package com.pafgroup.springbootrestapi.controller;

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
import com.pafgroup.springbootrestapi.dao.ProductDAO; 
import com.pafgroup.springbootrestapi.model.Product; 

@RestController 
@RequestMapping("/company")
public class ProductController {
	@Autowired  
	ProductDAO productDAO; 
	 
	 /* SAVE AN PRODUCT */  
	@PostMapping("/products")  
	public Product createProduct(@Valid @RequestBody Product pro) {   
		return productDAO.save(pro);  
		} 
	
	/* GET ALL PRODUCTS*/  
	@GetMapping("/products")  
	public List<Product> getAllProducts(){   
		return productDAO.findAll();  
		} 
	
	/* GET PRODUCT BY ID */  
	@GetMapping("/products/{product_code}")  
	public ResponseEntity<Product> getProductById(@PathVariable(value="product_code") Long proId){   
		Product pro = productDAO.findOne(proId);      
		if(pro==null) {   
			return ResponseEntity.notFound().build();   
			}   
		return ResponseEntity.ok().body(pro);   
		}
	
	/* UPDATE AN PRODUCT BY ID */  
	@PutMapping("/products/{product_code}")  
	public ResponseEntity<Product> updateProduct(@PathVariable(value="product_code") Long proId, @Valid @RequestBody Product proDetails){
		Product pro=productDAO.findOne(proId);      
		if(pro==null) {    
			return ResponseEntity.notFound().build();   
			}   
		pro.setProduct_name(proDetails.getProduct_name());   
		pro.setPro_reg_fk_type_id(proDetails.getPro_reg_fk_type_id());   
		pro.setDescription(proDetails.getDescription());
		pro.setStatus(proDetails.getStatus());
		pro.setDate_time(proDetails.getDate_time());
		pro.setPro_reg_fk_user_id(proDetails.getPro_reg_fk_user_id());
	
		Product updateProduct=productDAO.save(pro); 
		
		return ResponseEntity.ok().body(updateProduct);  
		}   
	
	/*DELETE AN PRODUCT*/  
	@DeleteMapping("/products/{product_code}")  
	public ResponseEntity<Product> deleteProduct(@PathVariable(value="product_code") Long proId){   
		Product pro = productDAO.findOne(proId);   
		if(pro==null) {    
			return ResponseEntity.notFound().build();   
			}   
		productDAO.delete(pro);   
		return ResponseEntity.ok().build();   
		}

}
