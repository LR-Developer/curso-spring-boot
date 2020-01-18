package br.com.babypet.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.babypet.domain.Cliente;
import br.com.babypet.dtos.commands.ClienteInsertCommand;
import br.com.babypet.dtos.commands.ClienteUpdateCommand;
import br.com.babypet.dtos.models.ClienteItemModel;
import br.com.babypet.dtos.models.ClienteListModel;
import br.com.babypet.services.ClienteService;

@RestController
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping("clientes")
	public ResponseEntity<?> incluir(@Valid @RequestBody ClienteInsertCommand command) {

		Cliente cliente = clienteService.incluir(command);

		return ResponseEntity.ok(cliente);
	}
	
	@GetMapping("clientes")
	public ResponseEntity<?> listar() {
		
		List<Cliente> clientes = clienteService.listar();
		
		List<ClienteListModel> model = ClienteListModel.of(clientes);
		
		return ResponseEntity.ok(model);
	}
	
	@GetMapping("clientes/{id}")
	public ResponseEntity<?> consultar(@PathVariable(name = "id") String id) {
		
		Cliente cliente = clienteService.consultar(id);
		
		ClienteItemModel model = ClienteItemModel.of(cliente);
		
		return ResponseEntity.ok(model);
	}
	
	@PutMapping("clientes/{id}")
	public ResponseEntity<?> alterar(
									@PathVariable(name = "id") String id,
									@Valid @RequestBody ClienteUpdateCommand command) {
		
		Cliente cliente = clienteService.alterar(id, command);
		
		return ResponseEntity.ok(cliente);
	}
	
	@DeleteMapping("clientes/{id}")
	public ResponseEntity<?> excluir(@PathVariable(name = "id") String id) {
		
		clienteService.excluir(id);
		
		return ResponseEntity.ok().build();
		
	}
}
