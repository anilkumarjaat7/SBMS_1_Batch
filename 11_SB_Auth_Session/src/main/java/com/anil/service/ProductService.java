package com.anil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anil.entity.Product;
import com.anil.repository.ProductRepository;

@Service
public class ProductService {
	
	
	private final ProductRepository productRepository;

	
	@Autowired
	public ProductService(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}
	
//	create
	
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
	
//	Read All
	
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	
//	Read one by Id
	
	public Product getProductById(Long id) {
		return productRepository.findById(id).orElse(null);
	}
	
//	 Upadte
	
	public Product updateProduct(Long id, Product product) {
		Product existingProduct = productRepository.findById(id).orElse(null);
		
		
		if(existingProduct == null) {
			return null;
		}
		
		
		existingProduct.setName(product.getName());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setImageUrl(product.getImageUrl());
		existingProduct.setCategory(product.getCategory());
		
		existingProduct.setBrand(product.getBrand());
		existingProduct.setStock(product.getStock());
		existingProduct.setIsActive(product.getIsActive());
		
		return productRepository.save(existingProduct);
	}
	
//	delete
	
	public boolean deleteProduct(Long id) {
		
		if(!productRepository.existsById(id)) {
			return false;
		}
		
		productRepository.deleteById(id);
		
		return true;
	}
	
	

	

  


	
	
	
	
	

}
