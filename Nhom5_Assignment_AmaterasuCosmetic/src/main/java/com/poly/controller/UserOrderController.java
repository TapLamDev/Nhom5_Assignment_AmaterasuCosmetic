package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserOrderController {
	@GetMapping("/checkOrder")
	public String checkOrder() {
		
		return "User/checkOrder";
	}
}
