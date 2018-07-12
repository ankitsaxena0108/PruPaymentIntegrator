package com.prud.zm.pi.batch.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.prud.zm.pi.batch.config.CommonComponantConfiguration;
import com.prud.zm.pi.batch.config.PropertyBeanConfig;

@SpringBootApplication
@Import({CommonComponantConfiguration.class,PropertyBeanConfig.class})
public class PaymentIntegratorApplication {
	public static void main(String[] args) {
		System.out.println("startup of Application");
		SpringApplication.run(PaymentIntegratorApplication.class, args);
	}
}
