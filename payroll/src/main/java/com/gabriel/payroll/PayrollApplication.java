package com.gabriel.payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//na verdade esse projeto Payroll é um cliente Ribbon ele que vai chamar outro projeto (worker) e essa chamada é com balanceamento de carga
//Balanceamento de cargas = ALTERNAR OS SERVICOS QUE É CHAMADO


@RibbonClient(name = "hr-worker")
@EnableFeignClients
@SpringBootApplication
public class PayrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayrollApplication.class, args);
	}

}
