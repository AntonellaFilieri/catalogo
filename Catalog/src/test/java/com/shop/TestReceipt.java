package com.shop;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
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
		String separator = new String(new char[100]).replace('\0', '-');
		String result = separator.concat("\r\n").concat("|").concat(StringUtils.center("Product", 64)).concat("|")
				.concat(StringUtils.center("Quantity", 16)).concat("|").concat(StringUtils.center("Price", 16))
				.concat("|").concat("\r\n").concat(separator).concat("\r\n").concat(separator).concat("\r\n");

		assertEquals(result, systemOutRule.getLog());
	}

	@Test
	public void testPlainTextReceipt() {

		Order order = new Order();
		OrderItem orderItem1 = new OrderItem(new Product("Book", new BigDecimal("34.28")), 2147483647);
		order.add(orderItem1);
		OrderItem orderItem2 = new OrderItem(new Product("Spaghetti Food", new BigDecimal("5.9")), 135);
		order.add(orderItem2);

		OrderItem orderItem3 = new OrderItem(new Product("CD U2",new BigDecimal("0")), 1);
		order.add(orderItem3);

		Receipt receipt = new PlainTextReceipt();
		receipt.print(order);

		String separator = new String(new char[100]).replace('\0', '-');

		String result = separator.concat("\r\n").concat("|").concat(StringUtils.center("Product", 64)).concat("|")
				.concat(StringUtils.center("Quantity", 16)).concat("|").concat(StringUtils.center("Price", 16))
				.concat("|").concat("\r\n").concat(separator).concat("\r\n");

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

		result = result.concat(separator).concat("\r\n");

		assertEquals(result, systemOutRule.getLog());

	}
}
