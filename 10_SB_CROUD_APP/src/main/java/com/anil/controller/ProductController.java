package com.anil.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anil.entity.Product;
import com.anil.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	private final ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	
	
//	Create
	
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		
		
		 Product saveProduct = productService.createProduct(product);
		 
		 return ResponseEntity.ok(saveProduct);
	}
	
//	GetAll
	@GetMapping
	public ResponseEntity<List<Product>> getAllProduct() {
		 
		 return ResponseEntity.ok( productService.getAllProducts());
	}
	
	
//	Get By Id
	
//	Update
	
//	Delete

}
