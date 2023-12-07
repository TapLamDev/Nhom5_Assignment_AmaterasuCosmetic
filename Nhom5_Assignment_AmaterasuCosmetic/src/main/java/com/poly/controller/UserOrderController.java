package com.poly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.poly.service.CartService;

@Controller
public class UserOrderController {
	@Autowired
	CartService cartService;
	
	@GetMapping("/checkOrder")
	public String checkOrder(Model model) {
		model.addAttribute("products", cartService.getAllItems());
		model.addAttribute("count", cartService.gettotalCount());
		model.addAttribute("roundedAmount", cartService.getAmount());
		return "User/checkOrder";
	}
}
