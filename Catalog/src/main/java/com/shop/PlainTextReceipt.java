package com.shop;

import java.time.LocalDate;
import java.time.Month;

import org.apache.commons.lang3.StringUtils;

public class PlainTextReceipt implements Receipt {

	private static Object[][] people = { { "Alice", LocalDate.of(2000, Month.JANUARY, 1) },
			{ "Bob", LocalDate.of(1989, Month.DECEMBER, 15) }, { "Carol", LocalDate.of(1992, Month.JULY, 24) },
			{ "Ted", LocalDate.of(2006, Month.MARCH, 13) }, };

	@Override
	public void print(Order order) {

		String productFormat = "| %1$-62s |";
		String quantityFormat = " %2$-14d |";
		String priceFormat = " %3$-14.2f |%n";
		String format = productFormat.concat(quantityFormat).concat(priceFormat);
		String line = new String(new char[100]).replace('\0', '-');

		System.out.println(line);
		System.out.printf("|%s|%s|%s|%n", StringUtils.center("Product", 64), StringUtils.center("Quantity", 16),
				StringUtils.center("Price", 16));
		System.out.println(line);

		for (OrderItem orderItem : order.getOrderItemList()) {
			String productName = orderItem.getProduct().getProductName();
			System.out.printf(format, productName.substring(0, Math.min(productName.length(), 62)), orderItem.getQuantity(),
					orderItem.getProduct().getPrice());
		}

		System.out.println(line);
	}

}
