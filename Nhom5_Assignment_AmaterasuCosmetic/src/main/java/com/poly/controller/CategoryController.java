package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.poly.dao.BrandDAO;
import com.poly.dao.CategoryDAO;
import com.poly.dao.ProductDAO;
import com.poly.entity.Brand;
import com.poly.entity.Category;
import com.poly.entity.Product;
import com.poly.service.CartService;

@Controller
public class CategoryController {
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
		model.addAttribute("count", cartService.gettotalCount());
		return "User/listCategory";
	}
	
	@GetMapping("/productCategory/{name}")
	public String productBrand(@PathVariable("name") String name, Model model) {
		    Category category = cdao.findByName(name);
		    List<Product> products = pdao.findByCategory(category);
	        model.addAttribute("products", products);
	        List<Category> categories = cdao.findAll();
	        model.addAttribute("category", category);
	        long productCount = pdao.countByCategory(category);
	        model.addAttribute("productCount", productCount);
			model.addAttribute("count", cartService.gettotalCount());
	        return "User/productCategory";
	}

}
