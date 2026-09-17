package com.anil.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PostMapping("/")
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
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id){
		Product product = productService.getProductById(id);
		
		if(product == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(product);
	}
	
//	Update
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
		
		Product updateProduct = productService.updateProduct(id, product);
		if(updateProduct == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(updateProduct);
	}
	
	
//	Delete
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long id){
		
		
		
		boolean deleteProduct = productService.deleteProduct(id);
		
		if(!deleteProduct) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok("Product deleted Successfully");
	}

}
