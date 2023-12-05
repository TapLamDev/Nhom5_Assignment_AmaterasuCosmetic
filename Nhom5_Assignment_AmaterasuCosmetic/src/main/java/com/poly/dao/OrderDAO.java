package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.Order;

public interface OrderDAO extends JpaRepository<Order, Long> {

	@Query("SELECT count(o) FROM Order o")
	Integer getCount();
	
}
