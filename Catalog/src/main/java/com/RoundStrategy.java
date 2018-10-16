package com;

import java.math.BigDecimal;

public interface RoundStrategy {

	BigDecimal round(BigDecimal initialValue);

}
