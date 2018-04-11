package com.pedroteixeira.projetomobicare.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pedroteixeira.projetomobicare.models.Colaborador;
import com.pedroteixeira.projetomobicare.models.ColaboradorResponse;
import com.pedroteixeira.projetomobicare.models.ColaboradorSetor;
import com.pedroteixeira.projetomobicare.models.Setor;
import com.pedroteixeira.projetomobicare.services.ColaboradorResponseService;
import com.pedroteixeira.projetomobicare.services.ColaboradorService;
import com.pedroteixeira.projetomobicare.services.SetorService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/colaboradores")
public class ColaboradorController {

	@Autowired
	private ColaboradorResponseService colServResp;
	@Autowired
	private ColaboradorService colServ;
	@Autowired
	private SetorService setServ;
	
	@ApiOperation(value="Lista todos os colaboradores agrupados por setor")
	@GetMapping
	public ResponseEntity<List<ColaboradorSetor>> findAllBySetor(){
		List<Setor> setores = setServ.findAll();
		List<ColaboradorResponse> colaboradores = colServResp.findAll();
		List<ColaboradorSetor> list = new ArrayList<ColaboradorSetor>() ;
		
		setores.forEach(n->{
			List<ColaboradorResponse> colaboradoresFiltrado = new ArrayList<ColaboradorResponse>() ;
			colaboradores.forEach(m->{
					if(n.getId().equals(m.getIdSetor())){
					colaboradoresFiltrado.add(m);
				}
			});
			list.add(new ColaboradorSetor(n,colaboradoresFiltrado));
		});
	
		return ResponseEntity.ok().body(list) ;
		
	}

	@ApiOperation(value="Insere um colaborador")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Não é possível inserir um colaborador se não houver o setor ou o setor for inválido")
	})
	@PostMapping
	public ResponseEntity<URI> insert(@RequestBody Colaborador obj){
		
		obj = colServ.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@ApiOperation(value="Procura um colaborador")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Colaborador> findById(@PathVariable String id){
		
		Colaborador obj = colServ.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value="Deleta um colaborador")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete(@PathVariable String id){
		
		colServ.delete(id);
		return ResponseEntity.ok().build();
	}
}
