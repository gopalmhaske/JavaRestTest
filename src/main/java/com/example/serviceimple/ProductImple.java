package com.example.serviceimple;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.example.model.Category;
import com.example.model.Product;
import com.example.repo.ProductRepo;
import com.example.service.ProductService;

public class ProductImple implements ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	

	@Override
	public Product createProduct(Product product) {
		
		Product save = this.productRepo.save(product);
		
		
		return save;
	}

	@Override
	public Product getProductById(int id) {
		
        Optional<Product> product = this.productRepo.findById(id);
		
		Product product1 = product.get();
		
		return product1;
		
	}

	@Override
	public Product updateProductById(Product product, int id) {
		

		Optional<Product> product2 = this.productRepo.findById(id);
		Product product3 = product2.get();
		product3.setTitle(product.getTitle());
		product3.setContent(product.getContent());
		product3.setCeatedDate(product.getCeatedDate());
		product3.setUpdatedDate(product.getUpdatedDate());
		
		Product save = this.productRepo.save(product3);
		
		return save;
		
		
	}

	@Override
	public void deleteProduct(int id) {

		Optional<Product> byId = this.productRepo.findById(id);
		
		Product product = byId.get();
		
		this.productRepo.delete(product);
		
		
	}



	@Override
	public Page<Product> getAllProduct(Integer pageNumber, Integer pageSize) {
		
		PageRequest pages = PageRequest.of(pageNumber, pageSize);
		Page<Product> allPages = this.productRepo.findAll(pages);
		return allPages;
	}

}
