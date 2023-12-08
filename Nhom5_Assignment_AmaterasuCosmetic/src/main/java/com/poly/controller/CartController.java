package com.poly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.dao.ProductDAO;
import com.poly.entity.CartItem;
import com.poly.entity.Product;
import com.poly.service.CartService;

@Controller
public class CartController {
	@Autowired
	ProductDAO pdao;

	@Autowired
	CartService cartService;

	//Form giỏ hàng
	@GetMapping("/cart")
	public String home(Model model) {
		model.addAttribute("products", cartService.getAllItems());
		model.addAttribute("count", cartService.gettotalCount());
		model.addAttribute("roundedAmount", cartService.getAmount());
		return "User/cart";
	}

	//Thêm vào giỏ hàng
	@GetMapping("/cart/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Product product = pdao.findById(id).get();
		model.addAttribute("products", product);
		if (product != null) {
			CartItem item = new CartItem();
			item.setId(product.getId());
			item.setName(product.getName());
			item.setImage(product.getImage());
			item.setPrice(product.getPrice());
			item.setTonKho(product.getTonKho());
			item.setQty(1);
			cartService.add(item);
		}
		model.addAttribute("message", "Sản phẩm đã được thêm vào giỏ hàng.");
		return "redirect:/detail/{id}";
	}
	
	//Mua ngay 
	@GetMapping("/cart/add/{id}")
	public String cartIted(Model model, @PathVariable("id") Integer id) {
		Product product = pdao.findById(id).get();
		model.addAttribute("products", product);
		if (product != null) {
			CartItem item = new CartItem();
			item.setId(product.getId());
			item.setName(product.getName());
			item.setImage(product.getImage());
			item.setPrice(product.getPrice());
			item.setTonKho(product.getTonKho());
			item.setQty(1);
			cartService.add(item);
		}
		model.addAttribute("message", "Sản phẩm đã được thêm vào giỏ hàng.");
		return "redirect:/cart";
	}

	//Tăng giá khi thêm số lượng sản phẩm
	@GetMapping("/cart/update/{id}/plus") // annotation xử lí yêu cầu
	public String plusQty(@PathVariable("id") int id, Model model) {
		cartService.plus(id);
		return "redirect:/cart";
	}

	//Ngược lại
	@GetMapping("/cart/update/{id}/minus") // annotation xử lí yêu cầu
	public String minusQty(@PathVariable("id") int id) {
		cartService.minus(id);
		return "redirect:/cart";
	}

	//Xóa sản phẩm
	@GetMapping("/cart/remove/{id}")
	public String RemoveCart(@PathVariable("id") int id) {
		cartService.remove(id);
		return "redirect:/cart";
	}

	//Xóa toàn bộ sản phẩm
	@RequestMapping("/cart/clear")
	public String ClearCart() {
		cartService.clear();
		return "redirect:/cart";
	}
	
}
