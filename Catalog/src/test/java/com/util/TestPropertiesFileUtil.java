package com.util;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.MissingResourceException;

import org.junit.Test;

import util.Constants;
import util.PropertiesFileUtil;

public class TestPropertiesFileUtil {

	@Test
	public void testGetPropertyValueAsList() {

		List<String> propertiesList = PropertiesFileUtil.getPropertyValueAsList(Constants.EXEMPT_PRODUCTS);

		assertTrue(propertiesList.size() != 0);
	}

	@Test
	public void testGetPropertyValueAsListFail() {

		try {
			List<String> propertiesList = PropertiesFileUtil.getPropertyValueAsList("not existing key");
		} catch (Exception e) {
			assertTrue(e instanceof MissingResourceException);
		}

	}
}
