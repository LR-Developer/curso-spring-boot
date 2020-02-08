package br.com.babypet.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.babypet.domain.Cliente;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String> {
	
	boolean existsByCpf(String cpf);
	
	List<Cliente> findByNomeContainsIgnoreCase(String nome);
	
	@Query(value = "db.cliente.find(\n" + 
			"    {   \n" + 
			"        $or:\n" + 
			"        [\n" + 
			"            { 'nome': { $regex: '?0', '$options': 'i' } },\n" + 
			"            { 'email': { $regex: '?1', '$options': 'i' } }\n" + 
			"        ]\n" + 
			"    }\n" + 
			")")
	List<Cliente> findByArgumentos(String nome, String email);
	
}
