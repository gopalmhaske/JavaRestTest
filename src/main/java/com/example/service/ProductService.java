package com.example.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.model.Category;
import com.example.model.Product;

public interface ProductService {
	
    Page<Product> getAllProduct(Integer pageNumber, Integer pageSize);
	
	Product createProduct(Product product);
	
	Product getProductById(int id);
	
	Product updateProductById(Product product, int id);
	
	void deleteProduct(int id);
	

}
