package com.shop;

import java.math.BigDecimal;

import com.model.Product;
import com.shop.tax.SaleTaxesCalculator;
import com.shop.tax.TaxesPolicy;

public class OrderItem {

	private Long id;
	private Product product;
	private int quantity;
	private BigDecimal totalPrice;


	private BigDecimal totalTax;
	private BigDecimal totalAmount;



	public OrderItem() {
	}

	public OrderItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public BigDecimal getTotalPrice() {
//		SaleTaxesCalculator saleTaxesCalculator = new SaleTaxesCalculator();
//		BigDecimal taxesAmount = saleTaxesCalculator.calculateTaxes(this.product, taxesPolicy);
//		BigDecimal productTaxedPrice = this.product.getPrice().add(taxesAmount);
//		this.totalPrice = productTaxedPrice.multiply(new BigDecimal(this.quantity));
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

}
