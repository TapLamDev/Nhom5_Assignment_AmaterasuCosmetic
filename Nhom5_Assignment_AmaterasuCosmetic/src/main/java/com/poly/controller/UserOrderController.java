package com.poly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.poly.entity.Account;
import com.poly.entity.Order;
import com.poly.service.AccountService;
import com.poly.service.CartService;
import com.poly.service.OrderService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserOrderController {
	@Autowired
	CartService cartService;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	HttpServletRequest request;
	
	@GetMapping("/checkOrder")
	public String checkOrder(Model model) {
		model.addAttribute("products", cartService.getAllItems());
		model.addAttribute("count", cartService.gettotalCount());
		model.addAttribute("roundedAmount", cartService.getAmount());
		
		HttpSession session = request.getSession();
		model.addAttribute("account", accountService.findByUserName(session.getAttribute("username").toString()));
		
		return "User/checkOrder";
	}
	
	@GetMapping("/orderDetail")
	public String orderDetail(Model model) {
		model.addAttribute("products", cartService.getAllItems());
		model.addAttribute("count", cartService.gettotalCount());
		model.addAttribute("roundedAmount", cartService.getAmount());
		
		HttpSession session = request.getSession();
		model.addAttribute("account", accountService.findByUserName(session.getAttribute("username").toString()));
		
		return "redirect/";
	}
//	@PostMapping("/checkOrder")
//	public String input(Model model, @ModelAttribute Order order) {
//		
//		return "User/checkOrder";
//	}
	
	
}
