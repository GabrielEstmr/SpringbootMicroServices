package com.gabriel.payroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	//Criação de Componente nao atraves de @Component da classe mas sim atraves de CHAMADA DE METODO
	//Immplementação Padrão de Projeto Singleton (instancia unica) - para ter a disposição o RestTemplate para ser injetado
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
