package com.shop;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import com.model.Product;

public class TestReceipt {

	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	@Test
	public void testEmptyPlainTextReceipt() {
		Order order = new Order();

		Receipt receipt = new PlainTextReceipt();
		receipt.print(order);
		String result = "----------------------------------------------------------------------------------------------------\r\n"
				+ "|                            Product                             |    Quantity    |     Price      |\r\n"
				+ "----------------------------------------------------------------------------------------------------\r\n"
				+ "----------------------------------------------------------------------------------------------------\r\n";
		assertEquals(result, systemOutRule.getLog());
	}

	@Test
	public void testPlainTextReceipt() {

		Order order = new Order();
		OrderItem orderItem = new OrderItem(new Product("Book", 34.28), 2147483647);
		order.add(orderItem);
		String productName = orderItem.getProduct().getProductName();
		productName = productName.substring(0, Math.min(productName.length(), 62));
		String productNameSpacing = new String(new char[62-productName.length()]).replace('\0', ' ');

		int quantity = orderItem.getQuantity();
		int quantityStringLength = String.valueOf(quantity).length();
		String price = String.format("%.2f", orderItem.getProduct().getPrice());
		String quantitySpacing = new String(new char[14-quantityStringLength]).replace('\0', ' ');

		Receipt receipt = new PlainTextReceipt();
		receipt.print(order);

		String result = "----------------------------------------------------------------------------------------------------\r\n"
				+ "|                            Product                             |    Quantity    |     Price      |\r\n"
				+ "----------------------------------------------------------------------------------------------------\r\n"
				+ "| " + productName + productNameSpacing +" | " + quantity + quantitySpacing + " | " + price + "          |\r\n"
				+ "----------------------------------------------------------------------------------------------------\r\n";
		assertEquals(result, systemOutRule.getLog());
	}
}
