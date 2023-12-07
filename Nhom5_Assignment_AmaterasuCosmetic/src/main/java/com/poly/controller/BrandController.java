package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.poly.entity.Brand;
import com.poly.entity.Product;
import com.poly.service.CartService;
import com.poly.dao.BrandDAO;
import com.poly.dao.ProductDAO;

@Controller
public class BrandController {
	@Autowired
	BrandDAO bdao;

	@Autowired
	ProductDAO pdao;
	
	@Autowired
	CartService cartService;

	@GetMapping("/brand")
	public String brand(Model model) {
		List<Brand> brands = bdao.findAll();
		model.addAttribute("brands", brands);
		model.addAttribute("count", cartService.gettotalCount());
		return "User/brand";
	}

	@GetMapping("/productBrand/{name}")
	public String productBrand(@PathVariable("name") String name, Model model) {
		  Brand brand = bdao.findByName(name);
	        List<Product> products = pdao.findByBrand(brand);
	        model.addAttribute("products", products);
	        List<Brand> brands = bdao.findAll();
	        model.addAttribute("brand", brand);
	        long productCount = bdao.countByBrand(brand);
	        model.addAttribute("productCount", productCount);
			model.addAttribute("count", cartService.gettotalCount());
	        return "User/productBrand";
	}
}
