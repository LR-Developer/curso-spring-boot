package br.com.babypet.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.babypet.domain.Cliente;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String> {
	
	
	
}
