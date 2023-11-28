package com.poly.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.Product;
import com.poly.entity.Report;

public interface ReportDAO extends JpaRepository <Product,Integer>{

//	@Query("SELECT new Report(o.category, sum(o.price), count(o)) " + " FROM Product o " 
//		     + " GROUP BY o.category"
//		     + " ORDER BY sum(o.price) DESC")
//		List<Report> getInventoryByCategorys();

	
}
