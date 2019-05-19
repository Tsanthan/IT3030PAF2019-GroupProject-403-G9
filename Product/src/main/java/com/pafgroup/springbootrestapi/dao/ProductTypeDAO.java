package com.pafgroup.springbootrestapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Isolation; 
import org.springframework.transaction.annotation.Transactional;

import com.pafgroup.springbootrestapi.model.ProductType;
import com.pafgroup.springbootrestapi.repository.ProductTypeRepository; 

@Service

public class ProductTypeDAO {
	@Autowired  
	ProductTypeRepository productTypeRepository;  
	
	/* SAVE AN PRODUCT TYPE */  
	@Transactional(readOnly = false,isolation = Isolation.READ_COMMITTED)
	public ProductType save(ProductType proType) {   
		return productTypeRepository.save(proType);  
		} 
	 
	 /* SEARCH ALL PRODUCT TYPE */  
	public List<ProductType> findAll(){   
		return productTypeRepository.findAll();  
		}    
	
	/* GET AN PRODUCT TYPE */ 
	public ProductType findOne(Long proTypeId) {   
		Optional<ProductType> op = productTypeRepository.findById(proTypeId);   
		if(op.isPresent()) {    
			return op.get();   
			}   
		else {    
			return null;   
			}  
		}
	
	/* DELETE AN PRODUCT TYPE by id */  
	@Transactional(readOnly = false,isolation = Isolation.READ_COMMITTED)  
	public void delete(ProductType proType) {   
		productTypeRepository.delete(proType);  
		}
}
