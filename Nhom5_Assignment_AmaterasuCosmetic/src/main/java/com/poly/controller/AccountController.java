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

	@GetMapping("/register")
	public String register() {
		return "User/register";
	}

	@GetMapping("/changePassword")
	public String changePassword() {
		return "User/changePassword";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute Account acc, Model model) {
		// Lấy giá trị từ dữ liệu biểu mẫu bằng đối tượng 'account'
		String username = acc.getUsername();
		String password = acc.getPassword();
		String fullName = acc.getFullname();
		String CCCD = acc.getCCCD();
		String email = acc.getEmail();
		
		// Tạo một thực thể Account mới với dữ liệu đã trích xuất
		Account newAccount = new Account();
		newAccount.setUsername(username);
		newAccount.setPassword(password);
		newAccount.setFullname(fullName);
		newAccount.setCCCD(CCCD);
		newAccount.setEmail(email);
		System.out.println(newAccount);
		
		return "redirect:/";
	}
}
