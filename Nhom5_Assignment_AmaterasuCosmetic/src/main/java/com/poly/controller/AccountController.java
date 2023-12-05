package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.entity.Account;

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

	//register
	@GetMapping("/register")
	public String register() {
		return "User/register";
	}

	@GetMapping("/changePassword")
	public String changePassword() {
		return "User/changePassword";
	}

	//registerssss
	@PostMapping("/register")
	public String register(@ModelAttribute Account account, Model model) {
		
		return "redirect:/";
	}
}
