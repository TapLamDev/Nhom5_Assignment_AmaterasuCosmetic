package com.poly.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poly.entity.Order;
import com.poly.entity.StatusOrder;
import com.poly.service.OrderService;

@CrossOrigin("*")
@RestController
public class OrderRestController {

	@Autowired
	OrderService orderService;
	
	 @GetMapping
	    public List<Order> getAllOrders() {
	        return orderService.getAll();
	    }

	    @GetMapping("/{id}")
	    public Order getOrderById(@PathVariable Long id) {
	        return orderService.getOne(id);
	    }

	    @PostMapping
	    public Order createOrder(@RequestBody Order order) {
	        return orderService.create(order);
	    }

	    @PutMapping("/{id}/update-status")
	    public Order updateOrderStatus(@PathVariable Long id, @RequestParam StatusOrder newStatus) {
	        return orderService.update(id, newStatus);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteOrder(@PathVariable Long id) {
	        orderService.delete(id);
	    }
	
	
}
