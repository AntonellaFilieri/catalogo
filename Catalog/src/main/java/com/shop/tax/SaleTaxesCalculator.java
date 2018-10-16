package com.shop.tax;

import java.math.BigDecimal;

import com.RoundStrategy;
import com.model.Product;

public class SaleTaxesCalculator {

	private RoundStrategy roundStrategy;
	private TaxesPolicy taxesPolicy;

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
		return this.roundStrategy.round(taxesAmount);
	}

}
