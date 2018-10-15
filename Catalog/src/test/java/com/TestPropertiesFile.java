package com;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

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
		assertNotNull(rb.getString("exempt.goods"));
		assertNotNull(rb.getString(Constants.BASE_SALES_TAX));
		assertNotNull(rb.getString(Constants.IMPORT_DUTY_SALES_TAX));
		assertTrue(StringUtils.isNotBlank(rb.getString("exempt.goods")));
		assertTrue(StringUtils.isNotBlank(rb.getString(Constants.BASE_SALES_TAX)));
		assertTrue(StringUtils.isNotBlank(rb.getString(Constants.IMPORT_DUTY_SALES_TAX)));

	}
}
