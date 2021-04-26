package com.gabriel.hruser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


//CommandLineRunner: pra rodar quando inicia o processo
@EnableEurekaClient
@SpringBootApplication
public class HruserApplication implements CommandLineRunner{
	
	//in jetando BCrypt: nao está instanciado por padrão 
	//=> tem que criar um BEAN deve pra ser injetável
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(HruserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BCRYPT = " + passwordEncoder.encode("123456"));
		
	}

}
