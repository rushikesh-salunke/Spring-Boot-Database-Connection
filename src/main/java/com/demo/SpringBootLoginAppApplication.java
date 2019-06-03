package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class SpringBootLoginAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLoginAppApplication.class, args);
	}

}
