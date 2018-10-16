package com.shop.tax;

import java.math.BigDecimal;

import com.model.Product;

public interface SaleTax {

	BigDecimal getRate();

	boolean isApplicable(Product product);

}
