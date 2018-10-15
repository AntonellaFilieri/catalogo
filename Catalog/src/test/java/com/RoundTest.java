package com;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class RoundTest {

	@Test
	@Parameters({ "0.00, 0.00", "1.00, 1.00", "0.05, 0.05", "0.044, 0.04", "1.045, 1.05", "0.046, 0.05", "0.0468, 0.05" })
	public void test(String input, String output) {
		BigDecimal initialValue = new BigDecimal(input);
		BigDecimal roundedValueExpected = new BigDecimal(output);
		RoundStrategy roundStrategy = new FiveRoundStrategy();
		assertEquals(roundedValueExpected, roundStrategy.round(initialValue));
	}

}
