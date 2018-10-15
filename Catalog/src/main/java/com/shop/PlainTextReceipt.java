package com.shop;

import java.util.Iterator;

import org.apache.commons.lang3.StringUtils;

public class PlainTextReceipt implements Receipt {

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

		Iterator<OrderItem> iterator = order.iterator();
		while (iterator.hasNext()) {
			OrderItem orderItem = iterator.next();
			String productName = orderItem.getProduct().getProductName();
			System.out.printf(format, productName.substring(0, Math.min(productName.length(), 62)), orderItem.getQuantity(),
					orderItem.getProduct().getPrice());
		}

		System.out.println(line);
	}

}
