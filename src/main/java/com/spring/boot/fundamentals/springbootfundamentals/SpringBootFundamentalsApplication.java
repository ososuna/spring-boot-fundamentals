package com.spring.boot.fundamentals.springbootfundamentals;

import com.spring.boot.fundamentals.springbootfundamentals.components.ComponentDependency;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootFundamentalsApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;

	public SpringBootFundamentalsApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency) {
		this.componentDependency = componentDependency;
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootFundamentalsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependency.doSomething();	
	}

}
