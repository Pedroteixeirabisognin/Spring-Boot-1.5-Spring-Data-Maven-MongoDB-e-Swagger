package com.pedroteixeira.projetomobicare;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	private final ResponseMessage m201 = simpleMessage(201, "Recurso criado");
	private final ResponseMessage m200 = simpleMessage(200, "Sucesso");
	private final ResponseMessage m404 = simpleMessage(404, "Não encontrado");
	private final ResponseMessage m400 = simpleMessage(400, "Requisição inválida");
	private final ResponseMessage m500 = simpleMessage(500, "Erro inesperado");
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET, Arrays.asList(m200, m404, m500, m400 ))
				.globalResponseMessage(RequestMethod.POST, Arrays.asList(m201,m400,m500))
				.globalResponseMessage(RequestMethod.DELETE, Arrays.asList(m200,m404,m400,m500))
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.pedroteixeira.projetomobicare.controllers"))				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
		
	}
	private ApiInfo apiInfo() {
		 return new ApiInfo(
		 "API criada para a Mobicare",
		 "Esta API será utilizada pela Mobicare para fins de avaliação",
		 "Versão 1.0",
		 "",
		 new Contact("Pedro Teixeira", "https://www.linkedin.com/in/pedro-teixeira-848741a1/", "pedroteixeirabisognin@gmail.com"),
		 "",
		 "",
		 Collections.emptyList() 
		);
	}
	private ResponseMessage simpleMessage(int code, String msg) {
		return new ResponseMessageBuilder().code(code).message(msg).build();
	}
}