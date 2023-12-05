package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.entity.Report;
import com.poly.dao.AccountDao;
import com.poly.dao.CategoryDAO;
import com.poly.dao.OrderDAO;
import com.poly.dao.ProductDAO;
import com.poly.dao.ReportDAO;

@Controller
public class AdminController {
	
	@Autowired
	ProductDAO pdao;
	@Autowired
	CategoryDAO cdao;
	@Autowired
	ReportDAO rdao;
	@Autowired
	AccountDao accountDao;
	@Autowired
	OrderDAO odao;

	@GetMapping("/admin/index")
	public String home(Model model) {
		model.addAttribute("account_count", accountDao.getCount());
		model.addAttribute("product_count", pdao.getCount());
		model.addAttribute("category_count", cdao.getCount());
		model.addAttribute("order_count",odao.getCount());
		List<Report> items = rdao.getInventoryByCategorys();
		model.addAttribute("items", items);
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
	
	@GetMapping("/admin/orders")
	public String showOrderPage(Model model) {
		return "Admin/order/orders";
	}
}
