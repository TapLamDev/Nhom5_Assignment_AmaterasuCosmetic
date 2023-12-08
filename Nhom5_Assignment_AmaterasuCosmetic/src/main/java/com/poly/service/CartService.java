package com.poly.service;

import java.util.Collection;

import com.poly.entity.CartItem;

public interface CartService {
	void remove(int id);
	void add(CartItem item);
	double getAmount();
	Collection<CartItem> getAllItems();
	void clear();
	CartItem update(int proId, int qty);
	CartItem plus(int id);
	CartItem minus(int id);
	int gettotalCount();
}
