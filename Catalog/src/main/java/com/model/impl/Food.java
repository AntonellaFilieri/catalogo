package com.model.impl;

import java.math.BigDecimal;

import com.model.Product;
import com.model.ProductOrigin;

public class Food extends Product {

	public Food() {
	}

	public Food(String productName) {
		super(productName);
	}
	
	public Food(String name, BigDecimal price) {
		super(name, price);
	}
	
	public Food(String name, BigDecimal price, ProductOrigin productOrigin) {
		super(name, price, productOrigin);
	}	

}
