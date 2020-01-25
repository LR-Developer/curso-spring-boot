package br.com.babypet.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.babypet.repositories.ClienteRepository;
import br.com.babypet.utils.ApplicationContextProvider;

public class CpfMustBeUniqueValidator implements ConstraintValidator<CpfMustBeUnique, String> {

	private ClienteRepository clienteRepository;

	@Override
	public void initialize(CpfMustBeUnique constraintAnnotation) {
		
		this.clienteRepository = ApplicationContextProvider.getComponent(ClienteRepository.class);
		
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		return !clienteRepository.existsByCpf(value);

	}
}
