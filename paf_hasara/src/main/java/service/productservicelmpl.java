package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.products;
import repository.productripo;

@Service
@Transactional

public class productservicelmpl implements productservice{
	
	@Autowired
	productripo productripo;

	 @Override
	 public List<products> getAllproducts() {
	  return (List<products>) productripo.findAll();
	 }

	 @Override
	 public products getproductsById(long id) {
	  return productripo.findById(id).get();
	 }

	 @Override
	 public void saveOrUpdate(products products) {
		 productripo.save(products);
	 }

	 @Override
	 public void deleteproducts(long id) {
		 productripo.deleteById(id);
	 }

}
