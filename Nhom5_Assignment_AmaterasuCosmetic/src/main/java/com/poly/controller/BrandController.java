package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BrandController {

	@GetMapping("/brand")
	public String brand() {
		return "User/brand";
	}
}
