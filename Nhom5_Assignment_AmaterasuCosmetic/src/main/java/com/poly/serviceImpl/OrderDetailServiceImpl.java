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
//	
//	@Autowired
//	OrderDetailDAO oddao;
//
//	@Override
//	public List<OrderDetail> findAll() {
//		// TODO Auto-generated method stub
//		return oddao.findAll();
//	}
//
//	@Override
//	public OrderDetail findById(Long id) {
//		// TODO Auto-generated method stub
//		return oddao.findById(id).get();
//	}

	@Override
	public List<OrderDetail> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetail findById(Long id) {
		// TODO Auto-generated method stub
		return orderDerailDAO.findById(id).get();
	}

}
