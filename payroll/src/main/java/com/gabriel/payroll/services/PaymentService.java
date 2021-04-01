package com.gabriel.payroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gabriel.payroll.entities.Payment;
import com.gabriel.payroll.entities.Worker;

@Service
public class PaymentService {
	
	@Value("${hostWorker}")
	private String workerHost;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Payment getPayment(long workerId, int days) {
		
		//Mapa = Dicionario de Parametros
		//Map: é só INTERFACE: para instanciar tem que usar classe concreta
		Map<String,String> uriVariables = new HashMap<>();
		uriVariables.put("id", "" + workerId);
		
		Worker worker =restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class,uriVariables);
		
//		return new Payment("BOB", 200.0, days);
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
		
	}
}
