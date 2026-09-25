package com.anil.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@GetMapping
	public String getPrducts() {
		return "products api - get All Products";
	}
	@GetMapping("/delete")
	public String deletePrducts() {
		return "products api - delete  Product";
	}
	
	

}
