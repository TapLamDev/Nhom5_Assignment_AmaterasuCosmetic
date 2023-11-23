package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@GetMapping("/admin/product")
	public String product() {
		return "Admin/product/products";
	}

	@GetMapping("/admin/brand")
	public String listProduct() {
		return "Admin/brand/brand";
	}
}
