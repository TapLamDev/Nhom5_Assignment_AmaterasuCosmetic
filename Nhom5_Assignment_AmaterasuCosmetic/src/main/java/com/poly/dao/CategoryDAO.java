package com.poly.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.poly.entity.Category;

public interface CategoryDAO extends JpaRepository<Category, Integer>{
	boolean existsByName(String name);
	
	@Query("SELECT count(o) FROM Category o")
	Integer getCount();

	Category findByName(String name);
	
	@Query("SELECT COUNT(p) FROM Product p WHERE p.category = :category")
	long countByBrand(@Param("category") Category category);
	
}
