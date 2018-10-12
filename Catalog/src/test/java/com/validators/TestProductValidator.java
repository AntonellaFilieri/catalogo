package com.validators;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;

import org.junit.Test;

import com.model.Product;

import exceptions.ProductException;
import validators.ProductValidator;
import validators.ProductValidatorImpl;

public class TestProductValidator {

	public ProductValidator validator = new ProductValidatorImpl();

	@Test
	public void testValidationSucceed() {
		try {
			validator.validate(new Product("ABCD", new BigDecimal("36.09")));
		} catch (ProductException e) {
			fail("Valid data and therefore not thrown an exception");
		}
	}
	
	@Test
	public void testPriceValidationFail() {
		try {
			validator.validate(new Product("ABCD", new BigDecimal("-36.09")));
		} catch (ProductException e) {
			 assertTrue(e.getMessage().contains(" Please specify a valid price "));
		}
	}

}