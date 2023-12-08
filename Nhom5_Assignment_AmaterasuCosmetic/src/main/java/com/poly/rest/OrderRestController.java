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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poly.entity.Category;
import com.poly.entity.Order;
import com.poly.entity.StatusOrder;
import com.poly.service.OrderService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orders")
public class OrderRestController {

	@Autowired
	OrderService orderService;
	
	 @GetMapping()
	    public List<Order> getAllOrders() {
	        return orderService.getAll();
	    }

	    @GetMapping("{id}")
	    public Order getOrderById(@PathVariable("id") Long id) {
	        return orderService.getOne(id);
	    }

	    @PostMapping()
	    public Order createOrder(@RequestBody Order order) {
	        return orderService.create(order);
	    }

	    @PutMapping("{id}")
	    public Order updateOrderStatus(@PathVariable("id") Long id, @RequestBody Order order) {
	        return orderService.update(order);
	    }

	    @DeleteMapping("{id}")
	    public void deleteOrder(@PathVariable("id") Long id) {
	        orderService.delete(id);
	    }
	
	
}
