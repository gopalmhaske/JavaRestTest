package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.ApiResponse;
import com.example.model.Category;
import com.example.model.Product;
import com.example.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	

	@GetMapping("/products")
	public Page<Product> getAllProduct(
			@RequestParam(value="pageSize", defaultValue="2",required = false) Integer pageSize,
			@RequestParam(value="pageNumber", defaultValue="3",required = false) Integer pageNumber
			
			)
	{
		Page<Product> allProduct = this.productService.getAllProduct(pageNumber, pageSize);
		return allProduct;
	}
	
	@PostMapping("/products")
	public ResponseEntity<Product> createProduct(@RequestBody Product product)
	{
		Product product1 = this.productService.createProduct(product);
		
		return new ResponseEntity<Product>(product1,HttpStatus.CREATED);
	}
	
	@GetMapping("/products/{di}")
	public ResponseEntity<Product> getProductById(@PathVariable("di") int id)
	{
		Product productById = this.productService.getProductById(id);
		
		return new ResponseEntity<Product>(productById,HttpStatus.OK);
	}
	
	@PutMapping("/products/{di}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable("di") int id)
	{
         		Product product1 = this.productService.updateProductById(product, id);
         		
         		return new ResponseEntity<Product>(product1,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/products/{di}")
	public ResponseEntity<ApiResponse> deleteProduct(@PathVariable("di") int id)
	{
		
		this.productService.deleteProduct(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Product Deleted Succesfully",true),HttpStatus.ACCEPTED);
		
	}
	

	
}
