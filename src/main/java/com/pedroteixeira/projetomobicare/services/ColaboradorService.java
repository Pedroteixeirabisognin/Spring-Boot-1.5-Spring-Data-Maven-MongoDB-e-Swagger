package com.pedroteixeira.projetomobicare.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedroteixeira.projetomobicare.models.Colaborador;
import com.pedroteixeira.projetomobicare.models.Setor;
import com.pedroteixeira.projetomobicare.repository.ColaboradorRepository;
import com.pedroteixeira.projetomobicare.repository.SetorRepository;
import com.pedroteixeira.projetomobicare.services.exceptions.BadRequestException;
import com.pedroteixeira.projetomobicare.services.exceptions.ObjectNotFoundException;

@Service
public class ColaboradorService {
	
	@Autowired
	private ColaboradorRepository repoCol;
	
	@Autowired
	private SetorRepository repoSet;


	
	public Colaborador insert(Colaborador obj) {
		Setor setor = repoSet.findOne(obj.getIdSetor());
		if(setor == null) {
			
			throw new BadRequestException("Requisição inválida, Setor deve ser válido");
		} 
		return repoCol.save(obj);
	}

	public Colaborador findById(String id) {
		Colaborador colaborador = repoCol.findOne(id);
		if(colaborador == null) {
			
			throw new ObjectNotFoundException("Colaborador não encontrado");
		} 
		return colaborador;
	}

	public void delete(String id) {
		findById(id);
		repoCol.delete(id);
	}
}
