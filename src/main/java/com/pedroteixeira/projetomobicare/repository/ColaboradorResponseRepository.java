package com.pedroteixeira.projetomobicare.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pedroteixeira.projetomobicare.models.ColaboradorResponse;

public interface ColaboradorResponseRepository extends MongoRepository<ColaboradorResponse, String> {

}
