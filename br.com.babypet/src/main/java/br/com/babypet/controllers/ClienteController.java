package br.com.babypet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.babypet.domain.Cliente;
import br.com.babypet.services.ClienteService;

@RestController
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping("clientes")
	public ResponseEntity<?> incluir() {

		Cliente cliente = clienteService.incluir("Jesus", "372", "jesus@email.com");

		return ResponseEntity.ok(cliente);
	}
}
