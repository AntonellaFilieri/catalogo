package com.shop;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestReceipt {

	@Test
	public void testEmptyReceipt() {
		Receipt receipt = new PlainTextReceipt();
		
		assertEquals(null, receipt.print());
	}

}
