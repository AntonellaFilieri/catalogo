package com.shop;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.FiveRoundStrategy;
import com.model.Product;
import com.model.ProductOrigin;
import com.model.impl.Book;
import com.shop.tax.BaseSaleTax;
import com.shop.tax.ImportDutySaleTax;
import com.shop.tax.SaleTaxesCalculator;
import com.shop.tax.TaxesPolicy;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class TestSaleTaxesCalculator {

	@Test
	@Parameters({ "34.697, 3.4697" })
	public void testBaseSaleTaxOnProduct(BigDecimal price, BigDecimal expectedTaxes) {
		Product parfume = new Product("Dior", price);
		TaxesPolicy taxesPolicy = new TaxesPolicy();
		taxesPolicy.add(new BaseSaleTax());
		SaleTaxesCalculator saleTaxCalculator = new SaleTaxesCalculator(taxesPolicy, new FiveRoundStrategy());
	
		BigDecimal calculatedTaxes = saleTaxCalculator.calculateTaxes(parfume);
		assertEquals(expectedTaxes, calculatedTaxes);
	}

	@Test
	@Parameters({ "34.697, 0.000" })
	public void testBaseSaleTaxOnExemptProduct(BigDecimal price, BigDecimal expectedTaxes) {
		Book book = new Book("Clean Code", price);

		TaxesPolicy taxesPolicy = new TaxesPolicy();
		taxesPolicy.add(new BaseSaleTax());
		SaleTaxesCalculator saleTaxCalculator = new SaleTaxesCalculator(taxesPolicy, new FiveRoundStrategy());

		BigDecimal calculatedTaxes = saleTaxCalculator.calculateTaxes(book);
		assertEquals(expectedTaxes, calculatedTaxes);
	}

	@Test
	@Parameters({ "13.378, 0.6689" })
	public void testImportDutySaleTaxOnProduct(BigDecimal price, BigDecimal expectedTaxes) {
		Product parfume = new Product("Dior", price, ProductOrigin.IMPORTED);
		TaxesPolicy taxesPolicy = new TaxesPolicy();
		taxesPolicy.add(new ImportDutySaleTax());

		SaleTaxesCalculator saleTaxCalculator = new SaleTaxesCalculator(taxesPolicy, new FiveRoundStrategy());

		BigDecimal calculatedTaxes = saleTaxCalculator.calculateTaxes(parfume);

		assertEquals(expectedTaxes, calculatedTaxes);
	}

	@Test
	@Parameters({ "34.697, 1.73485, IMPORTED" })
	public void testImportDutySaleTaxOnExemptProduct(BigDecimal price, BigDecimal expectedTaxes, String productOrigin) {
		Book book = new Book("Clean Code", price, ProductOrigin.valueOf(productOrigin));
		SaleTaxesCalculator saleTaxCalculator =  new SaleTaxesCalculator();
		TaxesPolicy taxesPolicy = new TaxesPolicy();
		taxesPolicy.add(new BaseSaleTax());
		taxesPolicy.add(new ImportDutySaleTax());
		BigDecimal calculatedTaxes = saleTaxCalculator.calculateTaxes(book);
		assertEquals(expectedTaxes, calculatedTaxes);
	}

	@Test
	@Parameters({ "25.853, 3.87795, IMPORTED", "25.853, 2.5853, LOCAL" })
	public void testBaseAndImportDutySaleTaxOnProduct(BigDecimal price, BigDecimal expectedTaxes,
			String productOrigin) {
		Product product = new Product("Dior", price, ProductOrigin.valueOf(productOrigin));
		SaleTaxesCalculator saleTaxCalculator = new SaleTaxesCalculator();
		TaxesPolicy taxesPolicy = new TaxesPolicy();
		taxesPolicy.add(new ImportDutySaleTax());
		taxesPolicy.add(new BaseSaleTax());

		BigDecimal calculatedTaxes = saleTaxCalculator.calculateTaxes(product);

		assertEquals(expectedTaxes, calculatedTaxes);
	}

}
