package com.model.impl;

import com.model.Product;
import com.model.ProductOrigin;

public class Book extends Product {

	private String author;

	public Book() {
	}
	
	public Book(String name) {
		super(name);
	}

	public Book(String name, double price) {
		super(name, price);
	}

	public Book(String name, double price, ProductOrigin productOrigin) {
		super(name, price, productOrigin);
	}	

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
