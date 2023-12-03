package com.poly.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem{
	private Integer id;
	private String name;
	private double price;
	private String image;
	private int tonKho	;
	Shipping shipping = new Shipping();
	private int qty = 1;  //so luong 2
	
	Product product = new Product();
	public CartItem(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.image = product.getImage();
        this.tonKho = product.getTonKho();
        this.product = product;
    }
}
