package com.ejemplo.encuesta;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class EncuestaPruebas1Application {
	
	@Bean
	public ModelMapper modelMappler() {
		return new ModelMapper();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(EncuestaPruebas1Application.class, args);
	}

}
