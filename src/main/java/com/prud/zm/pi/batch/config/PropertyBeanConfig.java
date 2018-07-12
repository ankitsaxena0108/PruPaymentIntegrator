package com.prud.zm.pi.batch.config;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
@Configuration
public class PropertyBeanConfig {
	@Bean(name = "citbankMappingProperty")
	public static PropertiesFactoryBean citbankAttributes() {
	        PropertiesFactoryBean bean = new PropertiesFactoryBean();
	        bean.setLocation(new ClassPathResource(
	                "il-to-citibank-mapping.properties"));
	        return bean;
	}
}
