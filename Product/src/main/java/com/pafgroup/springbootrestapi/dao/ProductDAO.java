package com.pafgroup.springbootrestapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Isolation; 
import org.springframework.transaction.annotation.Transactional; 
import com.pafgroup.springbootrestapi.model.Product; 
import com.pafgroup.springbootrestapi.repository.ProductRepository; 

@Service

public class ProductDAO {
	@Autowired  
	ProductRepository productRepository;  
	
	/* SAVE AN PRODUCT */  
	@Transactional(readOnly = false,isolation = Isolation.READ_COMMITTED)
	public Product save(Product pro) {   
		return productRepository.save(pro);  
		} 
	 
	 /* SEARCH ALL PRODUCT */  
	public List<Product> findAll(){   
		return productRepository.findAll();  
		}    
	
	/* GET AN PRODUCT */ 
	public Product findOne(Long proId) {   
		Optional<Product> op = productRepository.findById(proId);   
		if(op.isPresent()) {    
			return op.get();   
			}   
		else {    
			return null;   
			}  
		}
	
	/* DELETE AN PRODUCT by id */  
	@Transactional(readOnly = false,isolation = Isolation.READ_COMMITTED)  
	public void delete(Product pro) {   
		productRepository.delete(pro);  
		}
}
