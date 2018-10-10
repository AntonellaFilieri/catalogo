package validators;

import com.model.Product;

import exceptions.ProductException;
import validators.generic.ValidatorUtil;

public class ProductValidatorImpl implements ProductValidator {

	@Override
	public void validate(Product product) throws ProductException {
		StringBuilder errorFields = new StringBuilder();

		errorFields.append(ValidatorUtil.notNullString.and(ValidatorUtil.notEmptyString)
				.and(ValidatorUtil.stringBetween(1, 100)).test(product.getProductName())
				.getFieldNameIfInvalid(" Please specify valid product name ").orElse(""));

		errorFields.append(ValidatorUtil.notNullDouble.and(ValidatorUtil.greaterThanZeroDouble)
				.test(product.getPrice())
				.getFieldNameIfInvalid(" Please specify a valid price ").orElse(""));
		String errors = errorFields.toString();
		if (!errors.isEmpty()) {
			throw new ProductException(errors);
		}
	}
}