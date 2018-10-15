package com.shop;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.model.Product;
import com.shop.tax.BaseSaleTax;
import com.shop.tax.SaleTaxesCalculator;
import com.shop.tax.TaxesPolicy;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class TestSaleTaxesCalculator {

	@Test
	@Parameters({ "34.697, 3.4697" })
	public void testTaxedPriceOnProduct(BigDecimal price, BigDecimal expectedTaxes) {
		Product parfume = new Product("Dior", price);
		SaleTaxesCalculator saleTaxCalculator = new SaleTaxesCalculator();
		TaxesPolicy taxesPolicy = new TaxesPolicy();
		taxesPolicy.add(new BaseSaleTax());

		BigDecimal calculatedTaxes = saleTaxCalculator.calculateTaxes(parfume, taxesPolicy);
		
		assertEquals(expectedTaxes, calculatedTaxes);
	}

}
