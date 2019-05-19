package com.pro;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class pro1c {

@RequestMapping("/hello")
	public String test() {
	
	return "hello world";
	
}
	
	
}
