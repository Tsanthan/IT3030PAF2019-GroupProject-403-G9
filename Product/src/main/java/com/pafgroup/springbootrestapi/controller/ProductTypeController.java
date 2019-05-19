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
import com.pafgroup.springbootrestapi.dao.ProductTypeDAO; 
import com.pafgroup.springbootrestapi.model.ProductType; 

@RestController 
@RequestMapping("/storeProductType")
public class ProductTypeController {
	@Autowired  
	ProductTypeDAO productTypeDAO; 
	 
	 /* SAVE AN PRODUCT TYPE */  
	@PostMapping("/productsType")  
	public ProductType createProductType(@Valid @RequestBody ProductType proType) {   
		return productTypeDAO.save(proType);  
		} 
	
	/* GET ALL PRODUCTS TYPE */  
	@GetMapping("/productsType")  
	public List<ProductType> getAllProductsType(){   
		return productTypeDAO.findAll();  
		} 
	
	/* GET PRODUCT BY ID TYPE */  
	@GetMapping("/productsType/{product_type_id}")  
	public ResponseEntity<ProductType> getProductTypeById(@PathVariable(value="product_type_id") Long proTypeId){   
		ProductType proType = productTypeDAO.findOne(proTypeId);      
		if(proType==null) {   
			return ResponseEntity.notFound().build();   
			}   
		return ResponseEntity.ok().body(proType);   
		}
	
	/* UPDATE AN PRODUCT TYPE BY ID */  
	@PutMapping("/productsType/{product_type_id}")  
	public ResponseEntity<ProductType> updateProductType(@PathVariable(value="product_type_id") Long proTypeId, @Valid @RequestBody ProductType proTypeDetails){
		ProductType proType=productTypeDAO.findOne(proTypeId);      
		if(proType==null) {    
			return ResponseEntity.notFound().build();   
			}   
		proType.setProduct_type_id(proTypeDetails.getProduct_type_id());   
		proType.setProduct_type(proTypeDetails.getProduct_type());   
		proType.setMain_category(proTypeDetails.getMain_category());
		proType.setSub_category(proTypeDetails.getSub_category());
		proType.setDescription(proTypeDetails.getDescription());
		proType.setStatus(proTypeDetails.getStatus());
		proType.setDate_time(proTypeDetails.getDate_time());
		proType.setPro_ty_reg_fk_user_id(proTypeDetails.getPro_ty_reg_fk_user_id());
	
		ProductType updateProductType=productTypeDAO.save(proType); 
		
		return ResponseEntity.ok().body(updateProductType);  
		}   
	
	/*DELETE AN PRODUCT TYPE*/  
	@DeleteMapping("/productsType/{product_type_id}")  
	public ResponseEntity<ProductType> deleteProductType(@PathVariable(value="product_type_id") Long proTypeId){   
		ProductType proType = productTypeDAO.findOne(proTypeId);   
		if(proType==null) {    
			return ResponseEntity.notFound().build();   
			}   
		productTypeDAO.delete(proType);   
		return ResponseEntity.ok().build();   
		}

}

