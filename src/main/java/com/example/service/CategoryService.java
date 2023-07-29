package com.example.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.model.Category;

public interface CategoryService {

	Page<Category> getAllCategory(Integer pageNumber, Integer pageSize);
	
	Category createCategory(Category category);
	
	Category getCategoryById(int id);
	
	Category updateCategoryById(Category category, int id);
	
	void deleteCategory(int id);
	
	
	
}
