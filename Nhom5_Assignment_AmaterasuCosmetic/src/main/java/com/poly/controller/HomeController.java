package com.poly.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.Product;
import com.poly.dao.ProductDAO;

@Controller
public class HomeController {
	@Autowired
	ProductDAO pdao;

	@GetMapping("/")
	public String homeIndex(Model model) {
		List<Product> products = pdao.findAll();
		model.addAttribute("page", products);
		model.addAttribute("products", products);
		return "User/index";
	}

	@GetMapping("/home")
	public String home(Model model) {
		List<Product> products = pdao.findAll();
		model.addAttribute("products", products);
		return "User/index";
	}

	@GetMapping("/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Product product = pdao.findById(id).orElse(null);
		if (product == null) {
			// Xử lý khi không tìm thấy sản phẩm
			return "redirect:/"; // Chuyển hướng về trang chủ hoặc trang thông báo lỗi
		}
		model.addAttribute("product", product);
		return "User/detail";
	}

	@GetMapping("/searchByName")
	public String searchByName(Model model, @RequestParam("keyword") String keyword) {
		List<Product> products = pdao.findByName(keyword);

		// Loại bỏ các sản phẩm không chứa từ khóa đã nhập
		List<Product> filteredProducts = new ArrayList<>();
		for (Product product : products) {
			if (product.getName().toLowerCase().contains(keyword.toLowerCase())) {
				filteredProducts.add(product);
			}
		}
		if (filteredProducts.isEmpty()) {
			model.addAttribute("message", "Không tìm thấy sản phẩm cần tìm!!!");
		}

		model.addAttribute("keyword", keyword);
		model.addAttribute("products", filteredProducts);
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
