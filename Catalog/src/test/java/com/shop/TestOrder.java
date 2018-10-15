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

	/**
	 * Scenario Order 1: 1 book at 12.49 1 music CD at 14.99 1 chocolate bar at 0.85
	 * 
	 */
	@Test
	public void testOrder1() {

		assertEquals("Order 1", new Order("Order 1").getOrderName());
	}

	/**
	 * Scenario Order 2: 1 imported box of chocolates at 10.00 1 imported bottle of
	 * perfume at 47.50
	 * 
	 */
//	@Test
//	public void testOrder2() {
//		fail("Not yet implemented");
//	}

	/**
	 * Scenario Order 3: 1 imported bottle of perfume at 27.99 1 bottle of perfume
	 * at 18.99 1 packet of headache pills at 9.75 1 box of imported chocolates at
	 * 11.25
	 * 
	 */
//	@Test
//	public void testOrder3() {
//		fail("Not yet implemented");
//	}
}
