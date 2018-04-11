package com.pedroteixeira.projetomobicare.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pedroteixeira.projetomobicare.models.Colaborador;

public interface ColaboradorRepository extends MongoRepository<Colaborador, String> {

}
