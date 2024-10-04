package com.sample.first.springbootapp1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class Springbootapp1Application {

	public static void main(String[] args) {
		SpringApplication.run(Springbootapp1Application.class, args);
	}

	public LocalValidatorFactoryBean validtor(MessageSource ms){

		LocalValidatorFactoryBean lvfb = new LocalValidatorFactoryBean() ;
		lvfb.setValidationMessageSource(ms);

		return lvfb;

	}

}
