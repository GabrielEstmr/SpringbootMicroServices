package com.gabriel.payroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gabriel.payroll.entities.Worker;

//Interface: para declarar o tipo de chamada do webService que vamos fazer (mesma coisa do que já temos em workerResource)

@Component
@FeignClient(name = "hr-worker", path = "/workers")
public interface WorkerFeignClient {
	
	@GetMapping(value = "/{id}")
	ResponseEntity<Worker> findById(@PathVariable Long id);
}
