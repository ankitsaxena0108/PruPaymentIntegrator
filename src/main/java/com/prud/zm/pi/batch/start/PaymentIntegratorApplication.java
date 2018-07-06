package com.prud.zm.pi.batch.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.prud.zm.pi.batch.config", "com.prud.zm.pi.batch.controller","com.prud.zm.pi.batch.helper",
		"com.prud.zm.pi.controller", "com.prud.zm.pi.service", "com.prud.zm.pi.persist", "com.prud.zm.pi.processor" })
@EnableJpaRepositories("com.prud.zm.pi.persist")
@EntityScan("com.prud.zm.pi.persistence.entity")
public class PaymentIntegratorApplication {

	public static void main(String[] args) {
		System.out.println("startup point vipul");
		SpringApplication.run(PaymentIntegratorApplication.class, args);
	}
}
