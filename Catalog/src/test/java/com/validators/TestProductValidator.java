package com.validators;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
			validator.validate(new Product("ABCD", 36.09));
		} catch (ProductException e) {
			fail("Should have been valid and therefore not thrown an exception");
		}
	}
	
	@Test
	public void testPriceValidationFail() {
		try {
			validator.validate(new Product("ABCD", -36.09));
		} catch (ProductException e) {
			 assertTrue(e.getMessage().contains(" Please specify a valid price "));
		}
	}

}