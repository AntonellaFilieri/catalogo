package com.shop;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.shop.tax.BaseSaleTax;
import com.shop.tax.ImportDutySaleTax;
import com.shop.tax.SaleTax;

public class TestSaleTax {

	@Test
	public void test10PercentBaseSaleTax() {
		SaleTax baseSaleTax = new BaseSaleTax();

		assertEquals(new BigDecimal("10"), baseSaleTax.getRate());
	}

	@Test
	public void test5PercentImportDutySaleTax() {
		SaleTax importDutySaleTax = new ImportDutySaleTax();

		assertEquals(new BigDecimal("5"), importDutySaleTax.getRate());
	}
}
