package com.shop;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.model.Product;

public class TestOrderItem {

	@Test
	public void testTotalCostOrderItem() {
		
		Product product = new Product("book", new BigDecimal("20.3444"));
		int quantity = 5;
		OrderItem orderItem = new OrderItem(product, quantity);
		
		assertEquals(new BigDecimal(quantity).multiply(product.getPrice()), orderItem.getTotalPrice());
		
	}
}
