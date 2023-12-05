package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	//
	@GetMapping("/admin/index")
	public String home(Model model) {
		return "Admin/index";
	}
	
	
	@GetMapping("/admin/brands")
	public String showBrandPage(Model model) {
		return "Admin/brand/brand";
	}
	
	@GetMapping("/admin/categories")
	public String showCategoryPage(Model model) {
		return "Admin/category/category";
	}
	
	@GetMapping("/admin/products")
	public String showProductPage(Model model) {
		return "Admin/product/products";
	}
}
