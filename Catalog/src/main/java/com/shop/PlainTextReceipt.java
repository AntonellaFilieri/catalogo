package com.shop;

import org.apache.commons.lang3.StringUtils;

public class PlainTextReceipt implements Receipt {

	@Override
	public String print() {
		String productFormat = "| %1$-20s | ";
        String quantityFormat = " %2$tb %2$td, %2$tY  | ";
        String priceFormat = " %3$3s |%n";
        String format = productFormat.concat(quantityFormat).concat(priceFormat);
        String line = new String(new char[68]).replace('\0', '-');

        System.out.println(line);
        System.out.printf("|%s|%s|%s|%n",
            StringUtils.center("Product", 32),
            StringUtils.center("Quantity", 16),
            StringUtils.center("Price", 16));
        System.out.println(line);

//        for (Object[] data : people) {
//            System.out.printf(format,
//                data[0], data[1],
//                ChronoUnit.YEARS.between((LocalDate) data[1], LocalDate.now()));
//        }

        System.out.println(line);
		return null;
	}

}
