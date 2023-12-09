package com.poly.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.OrderDetailDAO;
import com.poly.entity.OrderDetail;
import com.poly.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
	
	@Autowired
	OrderDetailDAO orderDerailDAO;

	@Override
	public List<OrderDetail> getAll() {
		// TODO Auto-generated method stub
		return orderDerailDAO.findAll();
	}

	@Override
	public OrderDetail create(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		return orderDerailDAO.save(orderDetail);
	}
	
}
