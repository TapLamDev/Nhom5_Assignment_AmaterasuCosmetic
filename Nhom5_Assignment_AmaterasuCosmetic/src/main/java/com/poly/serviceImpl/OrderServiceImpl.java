package com.poly.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.OrderDAO;
import com.poly.entity.Order;
import com.poly.entity.StatusOrder;
import com.poly.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDAO odao;
	
	
	@Override
	public List<Order> getAll() {
		// TODO Auto-generated method stub
		return odao.findAll();
	}

	@Override
	public Order getOne(Long id) {
		// TODO Auto-generated method stub
		return odao.findById(id).get();
	}

	@Override
	public Order create(Order order) {
		// TODO Auto-generated method stub
		return odao.save(order);
	}

	@Override
	public Order update(Long id, StatusOrder newStatus) {
		Order existingOrder = getOne(id);
        if (existingOrder != null) {
            existingOrder.setStatus(newStatus);
            return odao.save(existingOrder);
        }
        return null; // Order with the given ID not found
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		odao.deleteById(id);
	}

}
