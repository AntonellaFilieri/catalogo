package com.shop;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.model.Product;
import com.shop.tax.BaseSaleTax;
import com.shop.tax.ImportDutySaleTax;
import com.shop.tax.SaleTaxesCalculator;
import com.shop.tax.TaxesPolicy;

public class TestOrderItem {

	@Test
	public void testTotalPriceSingleOrderItem() {

		Product product = new Product("book", new BigDecimal("20.3444"));
		int quantity = 1;
		BigDecimal expectedTaxedPrice = new BigDecimal("20.3444").multiply(new BigDecimal("10"))
				.divide(new BigDecimal("100")).add(new BigDecimal("20.3444"));

		TaxesPolicy taxesPolicy = new TaxesPolicy();
		taxesPolicy.add(new BaseSaleTax());
		taxesPolicy.add(new ImportDutySaleTax());

		OrderItem orderItem = new OrderItem(product, quantity);

		assertEquals(expectedTaxedPrice, orderItem.getTotalPrice());

	}

	@Test
	public void testTotalPriceMultipleOrderItem() {

		Product product = new Product("book", new BigDecimal("20.3444"));
		int quantity = 5;
		BigDecimal expectedTaxedPrice = new BigDecimal("20.3444").multiply(new BigDecimal("10"))
				.divide(new BigDecimal("100")).add(new BigDecimal("20.3444"));
		OrderItem orderItem = new OrderItem(product, quantity);

		TaxesPolicy taxesPolicy = new TaxesPolicy();
		taxesPolicy.add(new BaseSaleTax());
		taxesPolicy.add(new ImportDutySaleTax());

		assertEquals(expectedTaxedPrice.multiply(new BigDecimal(quantity)), orderItem.getTotalPrice());

	}
}
