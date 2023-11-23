package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.poly.entity.Brand;
import com.poly.dao.BrandDAO;

@Controller
public class BrandController {
	@Autowired
	BrandDAO dao;

	@GetMapping("/brand")
	public String brand(Model model) {
		List<Brand> brand = dao.findAll();
		model.addAttribute("brands", brand);
		return "User/brand";
	}
}
