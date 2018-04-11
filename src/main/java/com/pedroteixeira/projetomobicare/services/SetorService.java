package com.pedroteixeira.projetomobicare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedroteixeira.projetomobicare.models.Setor;
import com.pedroteixeira.projetomobicare.repository.SetorRepository;

@Service
public class SetorService {

	@Autowired
	private SetorRepository repo;
	
	public List<Setor> findAll(){
		return repo.findAll();
	}

}
