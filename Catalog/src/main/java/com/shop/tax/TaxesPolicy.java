package com.shop.tax;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

import com.model.Product;

public class TaxesPolicy extends ArrayList<SaleTax> {


	public BigDecimal getTotalRate(Product product) {

		BigDecimal totalRate = new BigDecimal("0");
		Iterator<SaleTax> saleTaxtIterator = this.iterator();
		while (saleTaxtIterator.hasNext()) {
			SaleTax saleTax = saleTaxtIterator.next();
			if (saleTax.isApplicable(product)) {
				totalRate = totalRate.add(saleTax.getRate());
			}
		}
		return totalRate;
	}

}
