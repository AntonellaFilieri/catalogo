package com.model;

public class Product {

	private String productName;
	private ProductOrigin productOrigin;
	private Double price;

	public Product() {
		this.productOrigin = ProductOrigin.LOCAL;
		this.price = 0.0;
	}

	public Product(String productName) {
		this.productName = productName;
		this.productOrigin = ProductOrigin.LOCAL;
		this.price = 0.0;
	}

	public Product(String productName, double price) {
		
		this.productName = productName;
		this.productOrigin = ProductOrigin.LOCAL;
		this.price = price;
	}

	public Product(String productName, double price, ProductOrigin productOrigin) {
		this.productName = productName;
		this.price = price;
		this.productOrigin = productOrigin;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public ProductOrigin getProductOrigin() {
		return productOrigin;
	}

	public void setOrigin(ProductOrigin productOrigin) {
		this.productOrigin = productOrigin;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Object isImported() {
		return this.productOrigin == ProductOrigin.IMPORTED;
	}

}
