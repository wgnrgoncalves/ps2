package br.com.fiap.microservicos.PS2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import br.com.fiap.microservicos.PS2.model.Sdg;

public interface SdgRepository extends MongoRepository<Sdg, String> {

}
