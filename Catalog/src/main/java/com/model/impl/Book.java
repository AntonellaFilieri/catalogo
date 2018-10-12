package com.model.impl;

import java.math.BigDecimal;

import com.model.Product;
import com.model.ProductOrigin;

public class Book extends Product {

	private String author;

	public Book() {
	}
	
	public Book(String name) {
		super(name);
	}

	public Book(String name, BigDecimal price) {
		super(name, price);
	}

	public Book(String name, BigDecimal price, ProductOrigin productOrigin) {
		super(name, price, productOrigin);
	}	

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
