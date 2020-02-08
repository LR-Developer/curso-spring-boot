package br.com.babypet.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.babypet.dtos.commands.ClienteInsertCommand;
import br.com.babypet.dtos.commands.ClienteUpdateCommand;
import br.com.babypet.utils.exceptions.BadRequestException;

@Document(collection = "cliente")
public class Cliente {

	@Id
	private String id;
	private String nome;
	private String cpf;
	private String email;

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}

	protected Cliente() {

	}

	private Cliente(ClienteInsertCommand command) {

		this.nome = command.getNome();
		this.cpf = command.getCpf();
		this.email = command.getEmail();
	}

	public void editar(ClienteUpdateCommand command) {
		this.nome = command.getNome();
		this.email = command.getEmail();
	}
	
	public static Cliente criar(ClienteInsertCommand command) {
		
		command.validate();
		
		return new Cliente(command);
		
	}

}
