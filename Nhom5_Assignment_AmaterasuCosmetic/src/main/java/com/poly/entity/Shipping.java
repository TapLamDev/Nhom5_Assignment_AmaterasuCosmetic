package com.poly.entity;

import lombok.Data;

@Data
public class Shipping {
	 private int standard = 20000;
	 private int fast = 50000;
	 private String method;
}
