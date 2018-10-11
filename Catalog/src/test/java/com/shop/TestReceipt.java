package com.shop;

import static org.junit.Assert.assertEquals;

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
		OrderItem orderItem1 = new OrderItem(new Product("Book", 34.28), 2147483647);
		order.add(orderItem1);
		OrderItem orderItem2 = new OrderItem(new Product("Spaghetti Food", 5.9), 135);
		order.add(orderItem2);

		OrderItem orderItem3 = new OrderItem(new Product("CD", 0), 1);
		order.add(orderItem3);
		
		Receipt receipt = new PlainTextReceipt();
		receipt.print(order);

		String result = "----------------------------------------------------------------------------------------------------\r\n"
				+ "|                            Product                             |    Quantity    |     Price      |\r\n"
				+ "----------------------------------------------------------------------------------------------------\r\n";

		for (OrderItem orderItem : order.getOrderItemList()) {
			String productName = orderItem.getProduct().getProductName();
			productName = productName.substring(0, Math.min(productName.length(), 62));
			String productNameSpacing = new String(new char[62 - productName.length()]).replace('\0', ' ');
			
			int quantity = orderItem.getQuantity();
			int quantityStringLength = String.valueOf(quantity).length();
			String quantitySpacing = new String(new char[14 - quantityStringLength]).replace('\0', ' ');

			String price = String.format("%.2f", orderItem.getProduct().getPrice());
			String priceSpacing = new String(new char[14 - price.length()]).replace('\0', ' ');

			result = result.concat("| " + productName + productNameSpacing + " | " + quantity + quantitySpacing + " | "
					+ price + priceSpacing + " |\r\n");
		}

		result = result.concat(
				"----------------------------------------------------------------------------------------------------\r\n");

		assertEquals(result, systemOutRule.getLog());

	}
}
