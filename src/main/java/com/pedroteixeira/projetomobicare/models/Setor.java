package com.pedroteixeira.projetomobicare.models;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection="setores")
public class Setor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
    @NotNull
    @JsonProperty(required = true)
	private String descricao;
	
	
	public Setor() {
	}
	public Setor(String id, String descrição) {
		this.id = id;
		this.descricao = descrição;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
