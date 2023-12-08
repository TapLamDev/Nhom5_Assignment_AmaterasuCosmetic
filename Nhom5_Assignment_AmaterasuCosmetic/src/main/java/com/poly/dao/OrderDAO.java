package com.poly.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.Order;

public interface OrderDAO extends JpaRepository<Order, Long> {

	@Query("SELECT count(o) FROM Order o")
	Integer getCount();
	
	//lấy danh sách tất cả các orders kèm theo details
    @Query("SELECT o FROM Order o JOIN FETCH o.orderDetails")
    List<Order> findAllOrdersWithDetails();
	
}
