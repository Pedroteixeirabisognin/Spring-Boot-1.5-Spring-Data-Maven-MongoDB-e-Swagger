package com.pedroteixeira.projetomobicare.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pedroteixeira.projetomobicare.models.Setor;

public interface SetorRepository extends MongoRepository<Setor, String> {

}
