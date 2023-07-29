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
import com.example.service.CategoryService;

@RestController
@RequestMapping("api")
public class CategoryController {
	
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/categories")
	public Page<Category> getAllCategory(
			@RequestParam(value="pageSize", defaultValue="2",required = false) Integer pageSize,
			@RequestParam(value="pageNumber", defaultValue="2",required = false) Integer pageNumber
			
			)
	{
		Page<Category> allCategory = this.categoryService.getAllCategory(pageNumber, pageSize);
		return allCategory;
	}
	
	@PostMapping("/categories")
	public ResponseEntity<Category> createCategory(@RequestBody Category category)
	{
		Category createCategory = this.categoryService.createCategory(category);
		
		return new ResponseEntity<Category>(createCategory,HttpStatus.CREATED);
	}
	
	@GetMapping("/categories/{di}")
	public ResponseEntity<Category> getcategoryById(@PathVariable("di") int id)
	{
		Category categoryById = this.categoryService.getCategoryById(id);
		
		return new ResponseEntity<Category>(categoryById,HttpStatus.OK);
	}
	
	@PutMapping("/categories/{di}")
	public ResponseEntity<Category> updateCategory(@RequestBody Category category, @PathVariable("di") int id)
	{
         		Category category2 = this.categoryService.updateCategoryById(category, id);
         		
         		return new ResponseEntity<Category>(category2,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/categories/{di}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable("di") int id)
	{
		
		this.categoryService.deleteCategory(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category Deleted Succesfully",true),HttpStatus.ACCEPTED);
		
	}
	

}
