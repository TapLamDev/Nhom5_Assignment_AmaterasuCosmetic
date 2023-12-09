package com.poly.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.entity.OrderDetail;
import com.poly.service.OrderDetailService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orderDetail")
public class OrderDetailRestController {

	@Autowired
	OrderDetailService oderDetailService;
	
	@GetMapping()
	public List<OrderDetail> getAll() {
		return oderDetailService.findAll();
	}
	
	@GetMapping("{id}")
	public OrderDetail getOne(@PathVariable("id") Long id) {
		return oderDetailService.findById(id);
	}
	
}
