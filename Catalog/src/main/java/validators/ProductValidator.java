package validators;

import com.model.Product;

import exceptions.ProductException;

public interface ProductValidator {
	public void validate(Product product) throws ProductException;
}