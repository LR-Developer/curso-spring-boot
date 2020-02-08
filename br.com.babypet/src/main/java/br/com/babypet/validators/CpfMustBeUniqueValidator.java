package br.com.babypet.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.babypet.repositories.ClienteRepository;
import br.com.babypet.utils.ApplicationContextProvider;

public class CpfMustBeUniqueValidator implements ConstraintValidator<CpfMustBeUnique, String> {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		return !clienteRepository.existsByCpf(value);

	}
}
