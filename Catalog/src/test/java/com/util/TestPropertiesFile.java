package com.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.model.impl.Book;
import com.model.impl.Food;
import com.model.impl.Medical;
import com.model.impl.Movie;

import util.Constants;

public class TestPropertiesFile {

	private static ResourceBundle rb = ResourceBundle.getBundle("config");

	@Test
	public void testEmptyPropertyFile() {
		assertTrue(rb != null);
	}

	@Test
	public void testPropertyFile() {
		assertTrue(rb != null);
		assertNotNull(rb.getString(Constants.EXEMPT_PRODUCTS));
		assertNotNull(rb.getString(Constants.BASE_SALES_TAX));
		assertNotNull(rb.getString(Constants.IMPORT_DUTY_SALES_TAX));
		assertTrue(StringUtils.isNotBlank(rb.getString(Constants.EXEMPT_PRODUCTS)));
		assertTrue(StringUtils.isNotBlank(rb.getString(Constants.BASE_SALES_TAX)));
		assertTrue(StringUtils.isNotBlank(rb.getString(Constants.IMPORT_DUTY_SALES_TAX)));

		String productList = (String) rb.getObject(Constants.EXEMPT_PRODUCTS);

		List<String> list = Arrays.stream(productList.toLowerCase().split(",")).map(String::trim)
				.collect(Collectors.toList());
		boolean match = list.stream().anyMatch(s -> list.contains(Book.class.getSimpleName().toLowerCase()));

		assertTrue(match);
	}

	@Test
	public void testExemptProductsInPropertyFile() {

		String productList = (String) rb.getObject(Constants.EXEMPT_PRODUCTS);

		List<String> list = Arrays.stream(productList.toLowerCase().split(",")).map(String::trim)
				.collect(Collectors.toList());

		boolean matchBook = list.stream().anyMatch(s -> list.contains(Book.class.getSimpleName().toLowerCase()));
		boolean matchFood = list.stream().anyMatch(s -> list.contains(Food.class.getSimpleName().toLowerCase()));
		boolean matchMedical = list.stream().anyMatch(s -> list.contains(Medical.class.getSimpleName().toLowerCase()));
		boolean matchMovie = list.stream().anyMatch(s -> list.contains(Movie.class.getSimpleName().toLowerCase()));

		assertTrue(matchBook);
		assertTrue(matchFood);
		assertTrue(matchMedical);
		assertFalse(matchMovie);
	}

}
