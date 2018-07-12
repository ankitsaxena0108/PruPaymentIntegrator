package com.prud.zm.pi.batch.config;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
@Configuration
public class PropertyBeanConfig {
	@Bean(name = "citbankMappingProperty")
	public static PropertiesFactoryBean citbankMappingProperty() {
	        PropertiesFactoryBean bean = new PropertiesFactoryBean();
	        bean.setLocation(new ClassPathResource(
	                "il-to-citibank-mapping.properties"));
	        return bean;
	}
	
	@Bean(name = "ilToIlEntityProperty")
	public static PropertiesFactoryBean ilToIlEntityProperty() {
	        PropertiesFactoryBean bean = new PropertiesFactoryBean();
	        bean.setLocation(new ClassPathResource(
	                "il-to-ilEntity-mapping.properties"));
	        return bean;
	}
	
	@Bean(name = "ilToEasypayProperties")
	public static PropertiesFactoryBean ilToEasypayProperties() {
	        PropertiesFactoryBean bean = new PropertiesFactoryBean();
	        bean.setLocation(new ClassPathResource(
	                "il-to-easypay-mapping.properties"));
	        return bean;
	}
	@Bean(name = "citbankAttributes")
	public static PropertiesFactoryBean citbankAttributes() {
	        PropertiesFactoryBean bean = new PropertiesFactoryBean();
	        bean.setLocation(new ClassPathResource(
	                "citbank-attributes.properties"));
	        return bean;
	}
	@Bean(name = "easypayAttributes")
	public static PropertiesFactoryBean easypayAttributes() {
	        PropertiesFactoryBean bean = new PropertiesFactoryBean();
	        bean.setLocation(new ClassPathResource(
	                "easypay-attributes.properties"));
	        return bean;
	}
}
