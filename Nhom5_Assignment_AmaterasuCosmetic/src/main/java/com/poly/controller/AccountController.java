package com.poly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.dao.AccountDao;
import com.poly.entity.Account;
import com.poly.entity.CartItem;
import com.poly.service.AccountService;
import com.poly.service.CartService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@Autowired
	CartService cartService;

	@Autowired
	HttpServletRequest request;
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("checkpass", false);
		return "User/login";
	}

	@PostMapping("/login")
	public String home(Model model, @RequestParam("username") String username,
			@RequestParam("password") String password) {
		try {
			Account account = accountService.findByUserName(username);
			if (account != null) {
				if (account.isAdmin()) {
					return "redirect:/admin/index";
				}
				if (!account.isActivated()) {
					model.addAttribute("checkpass", true);
					return "User/login";
				}
				if (account.getPassword().equals(password)) {
					// Tạo một đối tượng session
					HttpSession session = request.getSession();
					// Thêm dữ liệu tên người dùng vào session
					session.setAttribute("username", username);
					return "redirect:/home";
				}
				model.addAttribute("checkpass", true);
				return "User/login";
			} else {
				model.addAttribute("checkpass", true);
				return "User/login";
			}
		} catch (Exception e) {
			model.addAttribute("checkpass", true);
			return "User/login";
		}
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
	public String register(@ModelAttribute Account account, Model model) {
		return "redirect:/login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		cartService.clear();
		return "User/login";
	}
}
