package br.com.babypet.dtos.commands;

import javax.validation.constraints.NotBlank;

public class ClienteInsertCommand {

	@NotBlank(message = "Nome deve ser informado")
	private String nome;
	
	@NotBlank(message = "CPF deve ser informado")
	private String cpf;
	
	@NotBlank(message = "E-Mail deve ser informado")
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
	
}
