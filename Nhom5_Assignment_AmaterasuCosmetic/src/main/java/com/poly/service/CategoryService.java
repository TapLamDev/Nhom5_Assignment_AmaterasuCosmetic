package com.poly.service;

import java.util.List;

import com.poly.entity.Category;
import com.poly.entity.Product;

public interface CategoryService {

	List<Category> findAll();
	
	Category findById(int id);
	
	List<Category> findByCategoryId(int cid);
	
	Category create(Category category);
	
	Category update(Category category);
	
	void delete(int id);
	
}
