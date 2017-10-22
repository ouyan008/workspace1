package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component("triangle") 
public class Triangle implements Shape {
	
	private String color = "blue";
	@Override
	public String toString() {
		return "Tranglie [color=" + color + ", area=" + area + "]";
	}
	private float area = 20.0f;

	public void printColor() {
		System.out.println("color: " + color);
		
	}
	
	public Triangle () {
		
		System.out.println("Construct shape ...");
	}
	@Override
	public void printShape() {
		System.out.println("shape: " + area);
		
	}
	
	

}
