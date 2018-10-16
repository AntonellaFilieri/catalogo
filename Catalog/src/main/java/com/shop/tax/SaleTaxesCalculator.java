package com.shop.tax;

import java.math.BigDecimal;
import java.util.Arrays;

import com.FiveRoundStrategy;
import com.RoundStrategy;
import com.model.Product;

public class SaleTaxesCalculator {

	private RoundStrategy roundStrategy;
	private TaxesPolicy taxesPolicy;

	public SaleTaxesCalculator() {
		this.roundStrategy = new FiveRoundStrategy();
		this.taxesPolicy = new TaxesPolicy(
				Arrays.asList(new BaseSaleTax(), new ImportDutySaleTax()));
	}

	public SaleTaxesCalculator(RoundStrategy roundStrategy) {
		this.roundStrategy = roundStrategy;
	}

	public SaleTaxesCalculator(TaxesPolicy taxesPolicy, RoundStrategy roundStrategy) {
		this.setTaxesPolicy(taxesPolicy);
		this.roundStrategy = roundStrategy;
	}

	public void setRoundStrategy(RoundStrategy roundStrategy) {
		this.roundStrategy = roundStrategy;
	}

	public RoundStrategy getRoundStrategy() {
		return roundStrategy;
	}

	public TaxesPolicy getTaxesPolicy() {
		return taxesPolicy;
	}

	public void setTaxesPolicy(TaxesPolicy taxesPolicy) {
		this.taxesPolicy = taxesPolicy;
	}

	public BigDecimal calculateTaxes(Product product) {
		BigDecimal totalRate = taxesPolicy.getTotalRate(product);
		BigDecimal taxesAmount = product.getPrice().multiply(totalRate).divide(new BigDecimal(100));
		return taxesAmount;
	}

}
