package br.com.babypet.utils.validators;

import java.lang.reflect.Field;
import java.util.Iterator;

import javax.validation.ConstraintViolation;
import javax.validation.ElementKind;
import javax.validation.Path;

public abstract class AbstractValidator {

	private ConstraintViolation<?> ruleViolation;

	public void setRuleViolation(ConstraintViolation<?> ruleViolation) {
		this.ruleViolation = ruleViolation;
	}

	public String getMessage() {
		return this.ruleViolation.getMessage();
	}

	public String getField() {

		Path path = this.ruleViolation.getPropertyPath();
		Object object = this.ruleViolation.getLeafBean();

		String propertyName = null;

		for (Iterator<Path.Node> i = path.iterator(); i.hasNext();) {

			Path.Node node = i.next();

			if (ElementKind.PROPERTY.equals(node.getKind())) {

				// Field field = getFieldFromObject(object.getClass(), node.getName());

				// if (field != null) {

				propertyName = node.getName();

				// }

			}

		}

		return propertyName;

	}

	/*
	 * private Field getFieldFromObject(Class<?> type, String name) {
	 * 
	 * if (type != null) {
	 * 
	 * try {
	 * 
	 * return type.getDeclaredField(name);
	 * 
	 * } catch (NoSuchFieldException exception) {
	 * 
	 * return null;
	 * 
	 * }
	 * 
	 * }
	 * 
	 * return null;
	 * 
	 * }
	 */

}
