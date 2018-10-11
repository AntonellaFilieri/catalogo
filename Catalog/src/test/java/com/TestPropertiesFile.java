package com;

import static org.junit.Assert.*;

import java.util.ResourceBundle;

import static org.hamcrest.CoreMatchers.*;

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
		assertThat(rb.getString("exempt.goods"), is(notNullValue()));
		assertThat(rb.getString("base.rate"), is(notNullValue()));
		assertThat(rb.getString("import.rate"), is(notNullValue()));

	}
}
