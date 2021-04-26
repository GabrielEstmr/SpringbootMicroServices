package com.gabriel.hruser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;



@EnableEurekaClient
@SpringBootApplication
public class HruserApplication {

	public static void main(String[] args) {
		SpringApplication.run(HruserApplication.class, args);
	}

}
