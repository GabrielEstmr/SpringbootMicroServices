package com.gabriel.payroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.payroll.entities.Payment;
import com.gabriel.payroll.entities.Worker;
import com.gabriel.payroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {
	
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	public Payment getPayment(long workerId, int days) {
		
		//GetBody pois WorkerController retorna ResponseEntity ai tem que ter acceso ao body que é STRING
		Worker worker = workerFeignClient.findById(workerId).getBody();
		
//		return new Payment("BOB", 200.0, days);
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
		
	}
}
