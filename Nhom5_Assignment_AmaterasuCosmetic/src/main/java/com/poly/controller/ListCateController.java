package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poly.dao.BrandDAO;
import com.poly.dao.CategoryDAO;
import com.poly.dao.ProductDAO;
import com.poly.entity.Brand;
import com.poly.entity.Category;
import com.poly.entity.Product;
import com.poly.service.CartService;

@Controller
public class ListCateController {
	@Autowired
	CategoryDAO cdao;

	@Autowired
	ProductDAO pdao;

	@Autowired
	CartService cartService;

	@GetMapping("/listCategory")
	public String category(Model model) {
		List<Category> categories = cdao.findAll();
		model.addAttribute("categories", categories);
		List<Product> products = pdao.findAll();
		model.addAttribute("page", products);
		model.addAttribute("products", products);
		model.addAttribute("count", cartService.gettotalCount());
		return "User/listCategory";
	}

	@GetMapping("/product/{name}")
	public String productCategory(@PathVariable("name") String name, Model model) {
		Category category = cdao.findByName(name);

		if (category == null) {
			return "redirect:/listCategory";
		}

		List<Product> products = pdao.findByCategory(category);
		long productCount = pdao.countByCategory(category);

		model.addAttribute("category", category);
		model.addAttribute("products", products);
		model.addAttribute("productCount", productCount);

		List<Category> categories = cdao.findAll();
		model.addAttribute("categories", categories);
		model.addAttribute("count", cartService.gettotalCount());
		return "User/listCategory";
	}
}
