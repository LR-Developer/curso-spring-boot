package br.com.babypet.utils.exceptions;

import java.time.LocalDateTime;
import java.util.List;

public class MessageErrorResponse {

	private String message;
	private LocalDateTime datetime;
	private List<MessageErrorDetail> errors;
	
	public String getMessage() {
		return this.message;
	}

	public LocalDateTime getDatetime() {
		return this.datetime;
	}

	public List<MessageErrorDetail> getErrors() {
		return this.errors;
	}

	public MessageErrorResponse(String message, List<MessageErrorDetail> errors) {
		this.message = message;
		this.datetime = LocalDateTime.now();
		this.errors = errors;
	}
}
