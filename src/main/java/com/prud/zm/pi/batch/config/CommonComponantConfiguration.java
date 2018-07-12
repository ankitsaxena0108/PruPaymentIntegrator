package com.prud.zm.pi.batch.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = { "com.prud.zm.pi.batch.config", "com.prud.zm.pi.batch.controller",
		"com.prud.zm.pi.batch.helper", "com.prud.zm.pi.controller", "com.prud.zm.pi.service", "com.prud.zm.pi.persist",
		"com.prud.zm.pi.helper", "com.prud.zm.pi.mapper", "com.prud.zm.pi.batch.mapper","com.prud.zm.pi.persistence.entity","om.prud.zm.pi.model" })
@EnableJpaRepositories("com.prud.zm.pi.persist")
@EntityScan("com.prud.zm.pi.persistence.entity")
public class CommonComponantConfiguration {

}
