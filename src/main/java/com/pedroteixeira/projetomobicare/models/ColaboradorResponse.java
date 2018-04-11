package com.pedroteixeira.projetomobicare.models;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection="colaboradores")
@JsonIgnoreProperties({"id","cpf","telefone","idSetor"})
public class ColaboradorResponse implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	

    @NotNull
    @Size(max = 14)
    @JsonProperty(required = true)
	private String cpf;
    @NotNull
    @JsonProperty(required = true)
	private String nome;
    @NotNull
    @Size(max = 14) 
    @JsonProperty(required = true)
	private String telefone;
    @NotNull
    @JsonProperty(required = true)
	private String email;
    @NotNull
    @JsonProperty(required = true)
	private String idSetor;

	
	public ColaboradorResponse() {
		super();
	}

	public ColaboradorResponse(String id, String cpf, String nome, String telefone, String email,String idSetor) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.idSetor = idSetor;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdSetor() {
		return idSetor;
	}

	public void setIdSetor(String idSetor) {
		this.idSetor = idSetor;
	}
	
}
