package com.poly.service;

import java.util.List;

import com.poly.entity.Order;
import com.poly.entity.StatusOrder;

public interface OrderService {

	List<Order> getAll();
    Order getOne(Long id);
    Order create(Order order);
    Order update(Long id, StatusOrder newStatus);
    void delete(Long id);
	
}
