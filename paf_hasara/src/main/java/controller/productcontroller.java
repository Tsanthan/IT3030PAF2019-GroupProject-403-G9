package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.products;
import service.productservice;

@Controller
@RequestMapping(value="/products")
public class productcontroller {
	
	@Autowired
	productservice productservice;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list() {
	  ModelAndView model = new ModelAndView("products/products_list");
	  List<products> productsList = productservice.getAllproducts();
	  model.addObject("productsList", productsList);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/addproducts/", method=RequestMethod.GET)
	 public ModelAndView addproducts() {
	  ModelAndView model = new ModelAndView();
	  
	  products products = new products();
	  model.addObject("productsForm", products);
	  model.setViewName("products/products_form");
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/updateproducts/{id}", method=RequestMethod.GET)
	 public ModelAndView editproducts(@PathVariable long id) {
	  ModelAndView model = new ModelAndView();
	  
	  products products = productservice.getproductsById(id);
	  model.addObject("productsForm", products);
	  model.setViewName("products/products_form");
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/saveproducts", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("productsForm") products products) {
		 productservice.saveOrUpdate(products);
	  
	  return new ModelAndView("redirect:/products/list");
	 }
	 
	 @RequestMapping(value="/deleteproducts/{id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("id") long id) {
		 productservice.deleteproducts(id);
	  
	  return new ModelAndView("redirect:/products/list");
	 }

}
