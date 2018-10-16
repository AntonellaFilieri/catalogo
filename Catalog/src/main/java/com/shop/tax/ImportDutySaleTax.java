package com.shop.tax;

import java.math.BigDecimal;
import java.util.ResourceBundle;

import com.model.Product;

import util.Constants;
import util.CustomStringUtil;

public class ImportDutySaleTax implements SaleTax {

	private static ResourceBundle rb = ResourceBundle.getBundle("config");
	private BigDecimal rate;

	public ImportDutySaleTax() {
		this.rate = new BigDecimal(CustomStringUtil.adjustRate(rb.getString(Constants.IMPORT_DUTY_SALES_TAX)));
	}

	@Override
	public BigDecimal getRate() {
		return this.rate;
	}

	@Override
	public boolean isApplicable(Product product) {
		return product.isImported();
	}

}
