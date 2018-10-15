package util;

public class CustomStringUtil {

	public static String adjustRate(final String rate) {
		String validRate = rate;
		validRate = validRate.replaceAll("%", "");
		return validRate;

	}
}
