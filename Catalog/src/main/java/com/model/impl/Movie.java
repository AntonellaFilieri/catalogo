package com.model.impl;

import com.model.Product;
import com.model.ProductOrigin;

public class Movie extends Product {

	private String author;

	public Movie(String productName) {
		super(productName);
	}
	
	public Movie(String productName, double price) {
		super(productName, price);
	}
	
	public Movie(String productName, double price, ProductOrigin productOrigin) {
		super(productName, price, productOrigin);
	}	

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
