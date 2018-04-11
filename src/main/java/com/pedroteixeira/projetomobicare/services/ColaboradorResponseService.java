package com.pedroteixeira.projetomobicare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedroteixeira.projetomobicare.models.ColaboradorResponse;
import com.pedroteixeira.projetomobicare.repository.ColaboradorResponseRepository;

@Service
public class ColaboradorResponseService {
	
	@Autowired
	private ColaboradorResponseRepository repoColResp;

	
	public List<ColaboradorResponse> findAll(){
		return repoColResp.findAll();
	}
	
}
