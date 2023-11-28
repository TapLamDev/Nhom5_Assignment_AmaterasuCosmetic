package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {
	@GetMapping("/login")
	public String login() {
		return "User/login";
	}
	
	@GetMapping("/forgotPassword")
	public String forgotPassword() {
		return "User/forgotPassword";
	}
	
	@GetMapping("/register")
	public String register() {
		return "User/register";
	}
	
	@GetMapping("/changePassword")
	public String changePassword() {
		return "User/changePassword";
	}
}
