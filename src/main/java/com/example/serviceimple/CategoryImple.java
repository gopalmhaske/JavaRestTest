package com.example.serviceimple;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.model.Category;
import com.example.repo.CategoryRepo;
import com.example.service.CategoryService;

@Service
public class CategoryImple implements CategoryService {

	
	@Autowired
	private CategoryRepo categoryRepo;


	@Override
	public Category createCategory(Category category) {
		
		Category category2 = this.categoryRepo.save(category);
		
		return category2;
	}

	@Override
	public Category getCategoryById(int id) {
		
		Optional<Category> category = this.categoryRepo.findById(id);
		
		Category category2 = category.get();
		
		return category2;
	}

	@Override
	public Category updateCategoryById(Category category, int id) {
		
		Optional<Category> category2 = this.categoryRepo.findById(id);
		Category category3 = category2.get();
		category3.setTitle(category.getTitle());
		category3.setDescription(category.getDescription());
		
		Category category4 = this.categoryRepo.save(category3);
		
		return category4;
	}

	@Override
	public void deleteCategory(int id) {
		
		Optional<Category> byId = this.categoryRepo.findById(id);
		
		Category category = byId.get();
		
		this.categoryRepo.delete(category);
		
	}

	@Override
	public Page<Category> getAllCategory(Integer pageNumber, Integer pageSize) {
		
		PageRequest pages = PageRequest.of(pageNumber, pageSize);
		Page<Category> all = this.categoryRepo.findAll(pages);
		return all;
	}

}
