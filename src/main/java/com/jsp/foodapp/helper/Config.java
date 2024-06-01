package com.jsp.foodapp.helper;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.jsp")
public class Config 
{
	@Bean 
	public InternalResourceViewResolver resolver()
	{
		InternalResourceViewResolver irvr = new InternalResourceViewResolver();
		irvr.setPrefix("/");
		irvr.setSuffix(".jsp");
		return irvr;
	}
	
	@Bean
	public EntityManagerFactory getEMF()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("nanda");
		return emf;
	}
}
