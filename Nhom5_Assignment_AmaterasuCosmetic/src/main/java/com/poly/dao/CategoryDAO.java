package com.poly.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.Category;

public interface CategoryDAO extends JpaRepository<Category, Integer>{
	
	@Query("SELECT count(o) FROM Category o")
	Integer getCount();
	
}
