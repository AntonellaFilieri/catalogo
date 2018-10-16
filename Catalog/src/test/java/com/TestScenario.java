package com;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.model.Product;
import com.model.impl.Book;
import com.model.impl.Food;
import com.shop.Order;
import com.shop.OrderItem;
import com.shop.tax.BaseSaleTax;
import com.shop.tax.ImportDutySaleTax;
import com.shop.tax.SaleTaxesCalculator;
import com.shop.tax.TaxesPolicy;

public class TestScenario {

	/**
	 * Scenario Order 1: 1 book at 12.49 1 music CD at 14.99 1 chocolate bar at 0.85
	 * 
	 */
	@Test
	public void testOrderOne() {
		TaxesPolicy taxesPolicy = new TaxesPolicy();
		taxesPolicy.add(new BaseSaleTax());
		taxesPolicy.add(new ImportDutySaleTax());
		RoundStrategy roundStrategy = new FiveRoundStrategy();

		Order orderOne = new Order(new SaleTaxesCalculator(taxesPolicy, roundStrategy));
		Book book = new Book("Clean Code", new BigDecimal("12.49"));

		Product cd = new Product("cd ", new BigDecimal("14.99"));
		Food chocolate = new Food("Italian chocolate bar", new BigDecimal("0.85"));

		OrderItem bookOrderItem = new OrderItem(book, 2);
		orderOne.add(bookOrderItem);
		OrderItem cdOrderItem = new OrderItem(cd, 3);
		orderOne.add(cdOrderItem);
		OrderItem chocolateOrderItem = new OrderItem(chocolate, 4);
		orderOne.add(chocolateOrderItem);

		assertEquals(new BigDecimal("12.49"), bookOrderItem.getProductTaxedPrice(orderOne));
		assertEquals(new BigDecimal("16.49"), cdOrderItem.getProductTaxedPrice(orderOne));
		assertEquals(new BigDecimal("0.85"), chocolateOrderItem.getProductTaxedPrice(orderOne));
		
		assertEquals(new BigDecimal("12.49").multiply(new BigDecimal("2")), bookOrderItem.getTotalPrice(orderOne));
		assertEquals(new BigDecimal("16.49").multiply(new BigDecimal("3")), cdOrderItem.getTotalPrice(orderOne));
		assertEquals(new BigDecimal("0.85").multiply(new BigDecimal("4")), chocolateOrderItem.getTotalPrice(orderOne));

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
