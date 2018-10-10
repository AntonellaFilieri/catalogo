package com.model.impl;

import com.model.Product;
import com.model.ProductOrigin;

public class Food extends Product {

	public Food() {
	}

	public Food(String productName) {
		super(productName);
	}
	
	public Food(String name, double price) {
		super(name, price);
	}
	
	public Food(String name, double price, ProductOrigin productOrigin) {
		super(name, price, productOrigin);
	}	

}
