package com.poly.serviceImpl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.poly.entity.CartItem;
import com.poly.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	Map<Integer, CartItem> maps = new HashMap<>(); //gio hang
	
	@Override
	public void remove(int id) {
		maps.remove(id);
		
	}

	@Override
	public void add(CartItem item) {
		CartItem cartItem = maps.get(item.getId());
		if (cartItem == null) {
			maps.put(item.getId(), item);
		}
		else
		{
			cartItem.setQty(cartItem.getQty() +1);
		}
		
	}

	@Override
	public double getAmount() {
		return maps.values().stream()
				.mapToDouble(item -> item.getQty() * item.getPrice())
				.sum();		
	}
	
	@Override
	public double getAmountStandard() {
		return maps.values().stream()
				.mapToDouble(item -> (item.getQty() * item.getPrice()) + item.getShipping().getStandard())
				.sum();		
	}
	
	@Override
	public double getAmountFast() {
		return maps.values().stream()
				.mapToDouble(item -> (item.getQty() * item.getPrice()) + item.getShipping().getFast())
				.sum();		
	}
	

	
	@Override
	public int gettotalCount() {
	    int totalCount = 0;
	    for (CartItem cartItem : maps.values()) 
	    {
	        totalCount += cartItem.getQty();
	    }
	    return totalCount;
	}

	@Override
	public Collection<CartItem> getAllItems() {
		return maps.values();
	}

	@Override
	public void clear() {
		maps.clear();	
	}

	@Override
	public CartItem update(int id, int qty) {
		CartItem cartItem = maps.get(id);
		cartItem.setQty(qty);
		return cartItem;
	}
	
	@Override
	public CartItem plus(int id) {
	    CartItem cartItem = maps.get(id);
	    int qty = cartItem.getQty();
	    cartItem.setQty(qty + 1);
	    return cartItem;
	}

	@Override
	public CartItem minus(int id) {
		CartItem cartItem = maps.get(id);
	    int qty = cartItem.getQty();
	    if (qty < 1) {
	    	maps.remove(id);
		}
	    else
	    {
	    cartItem.setQty(qty - 1);
	    }
	    return cartItem;
	}



	
	
	

	
	
}