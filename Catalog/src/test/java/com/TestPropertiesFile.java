package com;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

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
		assertNotNull(rb.getString("base.rate"));
		assertNotNull(rb.getString("import.rate"));
		assertTrue(StringUtils.isNotBlank(rb.getString("exempt.goods")));
		assertTrue(StringUtils.isNotBlank(rb.getString("base.rate")));
		assertTrue(StringUtils.isNotBlank(rb.getString("import.rate")));

	}
}
