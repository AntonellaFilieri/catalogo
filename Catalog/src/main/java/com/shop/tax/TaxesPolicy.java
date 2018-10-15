package com.shop.tax;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaxesPolicy extends ArrayList<SaleTax> {

	public void setTax(SaleTax saleTax) {

	}

	public BigDecimal getTotalRate() {

		BigDecimal totalRate = new BigDecimal("0");
		Iterator<SaleTax> saleTaxtIterator = this.iterator();
		while (saleTaxtIterator.hasNext()) {
			SaleTax partialRate = saleTaxtIterator.next();
			totalRate = totalRate.add(partialRate.getRate());
			
		}
		return totalRate;
	}

}
