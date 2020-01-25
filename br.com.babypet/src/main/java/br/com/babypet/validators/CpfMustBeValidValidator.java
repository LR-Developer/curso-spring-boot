package br.com.babypet.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CpfMustBeValidValidator implements ConstraintValidator<CpfMustBeValid, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		value = value.replace(".", "");
	    value = value.replace("-", "");
	    
	    try{
	      Long.parseLong(value);
	    } catch(NumberFormatException e){
	      return false;
	    }

	    int d1, d2;
	    int digito1, digito2, resto;
	    int digitovalue;
	    String nDigResult;

	    d1 = d2 = 0;
	    digito1 = digito2 = resto = 0;

	    for (int nCount = 1; nCount < value.length() - 1; nCount++) {
	      digitovalue = Integer.valueOf(value.substring(nCount - 1, nCount)).intValue();

	      // multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4
	      // e assim por diante.
	      d1 = d1 + (11 - nCount) * digitovalue;

	      // para o segundo digito repita o procedimento incluindo o primeiro
	      // digito calculado no passo anterior.
	      d2 = d2 + (12 - nCount) * digitovalue;
	    };

	    // Primeiro resto da divisão por 11.
	    resto = (d1 % 11);

	    // Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11
	    // menos o resultado anterior.
	    if (resto < 2)
	      digito1 = 0;
	    else
	      digito1 = 11 - resto;

	    d2 += 2 * digito1;

	    // Segundo resto da divisão por 11.
	    resto = (d2 % 11);

	    // Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11
	    // menos o resultado anterior.
	    if (resto < 2)
	      digito2 = 0;
	    else
	      digito2 = 11 - resto;

	    // Digito verificador do value que está sendo validado.
	    String nDigVerific = value.substring(value.length() - 2, value.length());

	    // Concatenando o primeiro resto com o segundo.
	    nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

	    // comparar o digito verificador do value com o primeiro resto + o segundo
	    // resto.
	    return nDigVerific.equals(nDigResult);
		
	}
	
}
