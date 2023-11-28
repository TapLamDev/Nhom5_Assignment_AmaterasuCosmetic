package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.entity.Brand;

public interface BrandDAO extends JpaRepository<Brand, String> {
	boolean existsByName(String name);

	Brand findByName(String name);

	@Query("SELECT COUNT(p) FROM Product p WHERE p.brand = :brand")
	long countByBrand(@Param("brand") Brand brand);
}
