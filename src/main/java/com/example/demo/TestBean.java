package com.example.demo;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Circle;
import com.example.demo.model.Geometry;

@Component("testbean")
public class TestBean {
	
	
    Geometry geo;
	
	public TestBean() {
		System.out.println("construct TestBean");
	}
	
	
	public Geometry getGeo() {
		return geo;
	}



	@Resource(name="geometry")
	public void setGeo(Geometry geo) {
		System.out.println("set ... Testbaen geo" ) ;
		this.geo = geo;
	}




	public void testBean() { 
	System.out.println("Testbean: .." + geo);
	}
}
