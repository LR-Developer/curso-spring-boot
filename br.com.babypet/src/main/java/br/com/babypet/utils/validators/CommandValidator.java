package br.com.babypet.utils.validators;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import br.com.babypet.utils.exceptions.BadRequestException;
import br.com.babypet.utils.exceptions.MessageErrorDetail;

public class CommandValidator<T> extends AbstractValidator {

	public void validate(T command) {

		List<MessageErrorDetail> errors = new ArrayList<>();

		LocaleAwareMessageInterpolator interpolator = new LocaleAwareMessageInterpolator();

		interpolator.setDefaultLocale(new Locale("pt", "BR"));

		Validator validator = Validation.byDefaultProvider().configure().messageInterpolator(interpolator)
				.buildValidatorFactory().getValidator();

		Set<ConstraintViolation<T>> violations = validator.validate(command);

		for (ConstraintViolation<T> violation : violations) {
			
			setRuleViolation(violation);
			
			errors.add(new MessageErrorDetail(getField(), getMessage()));
			
		}

		if (!errors.isEmpty()) {
			throw new BadRequestException(errors);
		}

	}
}
