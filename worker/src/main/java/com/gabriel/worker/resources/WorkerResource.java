package com.gabriel.worker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.worker.entities.Worker;
import com.gabriel.worker.repositories.WorkerRepository;

//@RefreshScope => em toda classe que possui acesso as configurações
@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
	
	//Para imprimir coisas no log
	private static Logger logger = org.slf4j.LoggerFactory.getLogger(WorkerResource.class);
	
	@Value("${test.config}")
	private String testConfig;
	
	@Autowired
	private Environment env;

	@Autowired
	private WorkerRepository repository;
	
	@GetMapping(value = "/configs")
	public ResponseEntity<Void> getConfigs(){
		logger.info("CONFIG = " + testConfig);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		
		logger.info("PORT = " + env.getProperty("local.server.port"));
		
		List<Worker> list = repository.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		
		
		
		Worker obj = repository.findById(id).get();
		return ResponseEntity.ok(obj);
	}
}
