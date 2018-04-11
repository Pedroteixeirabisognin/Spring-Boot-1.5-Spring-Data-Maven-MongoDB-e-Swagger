package com.pedroteixeira.projetomobicare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pedroteixeira.projetomobicare.models.Colaborador;
import com.pedroteixeira.projetomobicare.models.Setor;
import com.pedroteixeira.projetomobicare.repository.ColaboradorRepository;
import com.pedroteixeira.projetomobicare.repository.SetorRepository;

@SpringBootApplication
public class ProjetoMobicare1Application implements CommandLineRunner {

	@Autowired
	private ColaboradorRepository Colrepository;
	@Autowired
	private SetorRepository Setrepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoMobicare1Application.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {

		if(Colrepository.count() == 0) {
			Colrepository.save(new Colaborador("Teste","Teste","Teste","Teste","Teste","Teste"));
		}
		
		if(Setrepository.count() == 0) {
			Setrepository.save(new Setor("Teste","Teste"));
		}
				
		
		System.out.println("Colaboradores found with findAll():");
		System.out.println("-------------------------------");
		for (Colaborador colaborador : Colrepository.findAll()) {
			System.out.println(colaborador);
		}
		System.out.println();

		System.out.println("Setores found with findAll():");
		System.out.println("-------------------------------");
		for (Setor setor : Setrepository.findAll()) {
			System.out.println(setor);
		}

		if(Colrepository.findOne("Teste") != null) {
			Colrepository.delete(Colrepository.findOne("Teste"));
		}
		if(Setrepository.findOne("Teste") != null) {
			Setrepository.delete(Setrepository.findOne("Teste"));
		}
	}
}
