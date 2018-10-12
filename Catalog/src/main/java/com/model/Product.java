package com.model;

import java.math.BigDecimal;

public class Product {

	private String productName;
	private ProductOrigin productOrigin;
	private BigDecimal price;

	public Product() {
		this.productOrigin = ProductOrigin.LOCAL;
		this.price = new BigDecimal("0.0");
	}

	public Product(String productName) {
		this();
		this.productName = productName;
	}

	public Product(String productName, BigDecimal price) {
		this.productName = productName;
		this.productOrigin = ProductOrigin.LOCAL;
		this.price = price;
	}

	public Product(String productName, BigDecimal price, ProductOrigin productOrigin) {
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Object isImported() {
		return this.productOrigin == ProductOrigin.IMPORTED;
	}

}
