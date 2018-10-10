package com.model.impl;

import com.model.Product;
import com.model.ProductOrigin;

public class Medical extends Product {

	public Medical() {
	}

	public Medical(String productName) {
		super(productName);
	}

	public Medical(String productName, double price) {
		super(productName, price);
	}
	
	public Medical(String productName, double price, ProductOrigin productOrigin) {
		super(productName, price, productOrigin);
	}	
}
