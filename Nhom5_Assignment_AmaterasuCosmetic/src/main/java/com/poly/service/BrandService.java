package com.poly.service;

import java.util.List;

import com.poly.entity.Brand;

public interface BrandService {

	List<Brand> findAll();
	
	Brand findById(String id);
	
	Brand create(Brand brand);
	
	Brand update(Brand brand);

	void delete(String id);
	
	
}
