package com.shop.tax;

import java.math.BigDecimal;
import java.util.ResourceBundle;

import com.model.Product;
import com.model.impl.Book;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import util.Constants;
import util.CustomStringUtil;

public class BaseSaleTax implements SaleTax {

	private static ResourceBundle rb = ResourceBundle.getBundle("config");
	private BigDecimal rate;

	public BaseSaleTax() {
		this.rate = new BigDecimal(CustomStringUtil.adjustRate(rb.getString(Constants.BASE_SALES_TAX)));

	}

	@Override
	public BigDecimal getRate() {
		return this.rate;
	}

	@Override
	public boolean isApplicable(Product product) {

		return true;
	}

}
