package com.shop;

import static org.junit.Assert.*;

import org.junit.Test;

import com.model.Product;

public class TestOrder {

	@Test
	public void testEmptyOrder() {
		Order order = new Order();

		assertEquals(0, order.size());
	}

	@Test
	public void testAddEmptyOrderItemToOrder() {
		Order order = new Order();
		OrderItem orderItem = new OrderItem();
		order.add(orderItem);

		assertEquals(1, order.size());
		assertEquals(0, orderItem.getQuantity());
	}

	@Test
	public void testAddSingleOrderItemWithSingleProductToOrder() {
		Order order = new Order();
		OrderItem orderItem = new OrderItem(new Product("well book"), 1);

		order.add(orderItem);
		assertEquals(1, order.size());
		assertEquals(1, orderItem.getQuantity());
	}

	@Test
	public void testAddMultipleOrderItemsWithMultipleProductsToOrder() {
		Order order = new Order();
		int orderItemsQuantity = 6;
		for (int i = 1; i <= orderItemsQuantity; i++) {
			OrderItem orderItem = new OrderItem(new Product("well book" + i), i);
			order.add(orderItem);

			assertEquals(i, orderItem.getQuantity());
			assertEquals("well book" + i, orderItem.getProduct().getProductName());
		}

		assertEquals(orderItemsQuantity, order.size());
	}

}
