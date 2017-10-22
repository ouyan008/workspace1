package com.example.demo;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.config.Myconfig;
import com.example.demo.model.Circle;
import com.example.demo.model.Dept;
import com.example.demo.model.Geometry;
import com.example.demo.repository.DeptRepository;

@SpringBootApplication
@EnableJms
//@Import(Myconfig.class)
public class SpringbootApplication {
	
      static TestBean testBean;
      ArrayList l;
	  LinkedList ll;

	  private static ApplicationContext context;
	  
		
	   
	public SpringbootApplication(){
		System.out.println("Construct SpringbootApplivation");
		
	}

	public  TestBean getTestBean() {
		return testBean;
	}



	@Autowired
	public  void setTestBean(TestBean testBean) {
		System.out.println("wire testBean");
		SpringbootApplication.testBean = testBean;
	}

    @Autowired
    public void setContext(ApplicationContext context) {
    	SpringbootApplication.context = context;
    }

   
    

	public static void main(String[] args) {
		
		SpringApplication.run(SpringbootApplication.class, args);
		System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
	//	ApplicationContext context = new AnnotationConfigApplicationContext(SpringbootApplication.class);
	//	TestBean testBean = context.getBean(TestBean.class);
	//	testBean.testBean();
		System.out.println("context:" + context);
		context.getBean(TestBean.class).testBean();
//		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
		System.out.println("Sending an email message");
	//	jmsTemplate.convertAndSend("mailbox", new Dept(50L, "SALE", "CHICAGO"));
	    RestTemplate restTemplate = context.getBean(RestTemplate.class);
			
//		String str = restTemplate.getForObject("http://localhost:8080/demo/depts", String.class);
		String str = restTemplate.getForObject("http://localhost:8080/demo/emps", String.class);
	    System.out.println(str);
	//	System.exit(0);
		
	}
	
//	@Bean
//	public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
//		
//		   DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
//		   configurer.configure(factory, connectionFactory);
//		   return factory;	
//	}
//	
//	@Bean 
//	public MessageConverter jacksonJmsMessageConveeerter() {
//		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
//		converter.setTargetType(MessageType.TEXT);
//		converter.setTypeIdPropertyName("_type");
//		return converter;
//	}
	
}
