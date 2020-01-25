package br.com.babypet.utils.validators;

import java.util.Locale;

import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;

public class LocaleAwareMessageInterpolator extends ResourceBundleMessageInterpolator {
	
	private Locale defaultLocale = Locale.getDefault();
	
	public void setDefaultLocale(Locale defaultLocale) {
		this.defaultLocale = defaultLocale;
	}
	
	

}
