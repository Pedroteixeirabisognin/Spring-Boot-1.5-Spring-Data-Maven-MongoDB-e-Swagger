package com.pedroteixeira.projetomobicare.models;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"Setor","colaboradores"})
public class ColaboradorSetor implements Serializable{
	private static final long serialVersionUID = 1L;

	private Setor setor;
	private List<ColaboradorResponse> colaboradores;
	
	public ColaboradorSetor() {
		
	}
	
	public ColaboradorSetor(Setor setor, List<ColaboradorResponse> colaboradores) {
		this.setor = setor;
		this.colaboradores = colaboradores;
	}
	@JsonGetter(value = "Setor")
	public Setor getDescricao() {
		return setor;
	}
	public void setDescricao(Setor descricao) {
		this.setor = descricao;
	}
	public List<ColaboradorResponse> getColaboradores() {
		return colaboradores;
	}
	public void setColaboradores(List<ColaboradorResponse> colaboradores) {
		this.colaboradores = colaboradores;
	}
	
	
}
