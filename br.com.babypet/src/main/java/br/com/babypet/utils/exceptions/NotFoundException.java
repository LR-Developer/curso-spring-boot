package br.com.babypet.utils.exceptions;

public class NotFoundException extends RuntimeException {

	public NotFoundException() {
		super("Not Found!");
	}
	
	public NotFoundException(String mensagem) {
		super(mensagem);
	}
}
