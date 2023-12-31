package com.poly.dao;


import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.Brand;
import com.poly.entity.Category;
import com.poly.entity.Product;

public interface ProductDAO extends JpaRepository<Product, Integer> {


	// Định nghĩa phương thức để phân trang và sắp xếp
    Page<Product> findAll(Pageable pageable);

    
    @Query("SELECT count(o) FROM Product o")
	Integer getCount();
    
    @Query("SELECT p FROM Product p WHERE p.name LIKE %:keyword%")


	List<Product> findByName(String keyword);
    
    List<Product> findByBrand(Brand brand);

	List<Product> findByCategory(Category category);

	long countByCategory(Category category);




}
