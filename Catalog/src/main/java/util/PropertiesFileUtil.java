package util;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class PropertiesFileUtil {

	private static ResourceBundle rb = ResourceBundle.getBundle("config");
	
	public static List<String> getPropertyValueAsList(String key) {
		
		String productList = (String) rb.getObject(key);

		List<String> list = Arrays.stream(productList.toLowerCase().split(",")).map(String::trim)
				.collect(Collectors.toList());
		return list;
	}

	
}
