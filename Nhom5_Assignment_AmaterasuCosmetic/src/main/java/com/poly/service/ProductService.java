package com.poly.service;

import java.util.List;

import com.poly.entity.Category;
import com.poly.entity.Product;

public interface ProductService {

	List<Product> findAll();
	
	Product findById(int id);
	
	List<Product> findByCategoryId(int cid);
	
	Product create(Product product);
	
	Product update(Product product);

	void delete(int id);



	
	
}
