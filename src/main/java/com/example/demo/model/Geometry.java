package com.example.demo.model;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("geometry")
public class Geometry {
	
	//DO NOT need a setter with the @Autowired, the value is set by reflection unless autowired annotated on  set method
	
	//@Resource(name = "circle")
	@Autowired @Qualifier("circle")
	private Shape cir;
	//@Resource(name = "tranglie")
	@Autowired @Qualifier("triangle")
	private Shape tri;
	
	
	public Shape getCircle() {
		return cir;
	}
	public Shape getTri() {
		return tri;
	}
	
	public Geometry() {
		System.out.println("construct Geometry ...");
	}

	
	@Override
	public String toString() {
		return "Geometry [circle=" + cir + ", tranglie=" + tri + "]";
//		return "Geometry [circle=" + circle1 + "]";
	}
	
	//@Autowired
//	public void setCircle(Circle circle) {
//		System.out.println("wiring geo circle ...");
//		this.cir = circle;
//	}
	//@Autowired
//	public void setTranglie(Tranglie tranglie) {
//		System.out.println("wiring geo tra ...");
//		this.tranglie = tranglie;
//	}

}
