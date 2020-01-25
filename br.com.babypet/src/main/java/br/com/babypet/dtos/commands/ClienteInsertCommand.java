package br.com.babypet.dtos.commands;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.babypet.utils.validators.CommandValidator;
import br.com.babypet.validators.CpfMustBeUnique;
import br.com.babypet.validators.CpfMustBeValid;

public class ClienteInsertCommand {

	@NotBlank(message = "Nome deve ser informado")
	@Size(min = 3, max = 50, message = "Nome deve estar entre 3 e 50 caracteres")
	private String nome;
	
	@NotBlank(message = "CPF deve ser informado")
	@CpfMustBeValid(message = "CPF deve ser válido")
	@CpfMustBeUnique(message = "CPF deve ser único")
	private String cpf;
	
	@NotBlank(message = "E-Mail deve ser informado")
	@Email(message = "E-Mail deve ser válido")
	private String email;
	
	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void validate() {
		
		CommandValidator<ClienteInsertCommand> commandValidator = new CommandValidator();
		
		commandValidator.validate(this);
	}
	
}
