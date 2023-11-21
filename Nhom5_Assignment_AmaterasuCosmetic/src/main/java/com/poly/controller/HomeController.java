package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String homeIndex() {
		return "User/index";
	}
	
	@GetMapping("/home")
	public String home() {
		return "User/index";
	}
	
	@GetMapping("/detail")
	public String detail() {
		return "User/detail";
	}
	
	@GetMapping("/search")
	public String search() {
		return "User/search";
	}
	
	
	@GetMapping("/about")
	public String about() {
		return "User/about";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "User/contact";
	}
	
}
