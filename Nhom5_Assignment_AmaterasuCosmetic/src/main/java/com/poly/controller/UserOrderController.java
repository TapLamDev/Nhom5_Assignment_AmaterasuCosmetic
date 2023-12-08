package com.poly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.poly.entity.Account;
import com.poly.service.AccountService;
import com.poly.service.CartService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserOrderController {
	@Autowired
	CartService cartService;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	HttpServletRequest request;
	
	@GetMapping("/checkOrder")
	public String checkOrder(Model model) {
		model.addAttribute("products", cartService.getAllItems());
		model.addAttribute("count", cartService.gettotalCount());
		model.addAttribute("roundedAmount", cartService.getAmount());
		
		HttpSession session = request.getSession();
		Account account = accountService.findByUserName(session.getAttribute("username").toString());
		model.addAttribute("account", account);
		
		return "User/checkOrder";
	}
}
