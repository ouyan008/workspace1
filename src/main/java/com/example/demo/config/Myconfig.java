package com.example.demo.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Circle;
import com.example.demo.model.Shape;

@Configuration
public class Myconfig {
	
	@Bean
	public Shape circle() {
		Circle circle = new Circle();
		circle.setColor("read");
		circle.setDiameter(10);
		return circle;
	}

	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
}
