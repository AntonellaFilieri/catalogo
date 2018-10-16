package com.model.impl;

import java.math.BigDecimal;

import com.model.Product;
import com.model.ProductOrigin;

public class Movie extends Product {

	private String author;

	public Movie() {
	}
	
	public Movie(String name) {
		super(name);
	}

	public Movie(String name, BigDecimal price) {
		super(name, price);
	}

	public Movie(String name, BigDecimal price, ProductOrigin productOrigin) {
		super(name, price, productOrigin);
	}	

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
