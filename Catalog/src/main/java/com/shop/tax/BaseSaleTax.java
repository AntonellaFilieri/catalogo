package com.shop.tax;

import java.math.BigDecimal;
import java.util.List;
import java.util.ResourceBundle;

import com.model.Product;
import com.model.impl.Book;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import util.Constants;
import util.CustomStringUtil;
import util.PropertiesFileUtil;

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
		
		List<String> exemptProducts = PropertiesFileUtil.getPropertyValueAsList(Constants.EXEMPT_PRODUCTS);
		boolean isExempt = exemptProducts.stream().anyMatch(s -> exemptProducts.contains(product.getClass().getSimpleName().toLowerCase()));

		return !isExempt;
	}

}
