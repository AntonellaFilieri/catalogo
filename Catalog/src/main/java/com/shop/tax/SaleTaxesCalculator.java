package com.shop.tax;

import java.math.BigDecimal;

import com.model.Product;

public class SaleTaxesCalculator {

	public BigDecimal calculateTaxes(Product product, TaxesPolicy taxesPolicy) {
		BigDecimal totalRate = taxesPolicy.getTotalRate(product);
		BigDecimal taxesAmount = product.getPrice().multiply(totalRate).divide(new BigDecimal(100));
		return taxesAmount;
	}

}
