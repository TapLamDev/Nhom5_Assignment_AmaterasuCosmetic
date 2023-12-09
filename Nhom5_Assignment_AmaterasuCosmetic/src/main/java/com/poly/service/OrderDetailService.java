package com.poly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.poly.entity.OrderDetail;

public interface OrderDetailService {

	List<OrderDetail> getAll();
	OrderDetail create(OrderDetail orderDetail);

	List<OrderDetail> findAll();
	OrderDetail findById(Long id);
	
}
