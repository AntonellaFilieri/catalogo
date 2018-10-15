package com;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FiveRoundStrategy implements RoundStrategy {

	@Override
	public BigDecimal round(BigDecimal initialValue) {
		return initialValue.setScale(2, RoundingMode.HALF_UP);
	}


}
