package service;

import java.util.List;

import model.*;
public interface productservice {
	
	public List<products> getAllproducts();
	 
	 public products getproductsById(long id);
	 
	 public void saveOrUpdate(products products);
	 
	 public void deleteproducts(long id);

}
