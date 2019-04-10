package br.com.indra.webreportsme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication
public class WebreportSmeRestFul extends SpringBootServletInitializer implements WebApplicationInitializer{
	 
	public static void main(String[] args) {
		SpringApplication.run(WebreportSmeRestFul.class, args);
	}
	
}
