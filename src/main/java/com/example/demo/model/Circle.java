package com.example.demo.model;

import org.springframework.stereotype.Component;

//@Component("circle")
public class Circle implements Shape {
	
	private String color;

	public String getColor() {
		return color;
	}

	public Circle() {
		
		System.out.println("Construct Circle..." );
	}
	
	public void setColor(String color) {
		System.out.println("Setting Color for Circle");
		this.color = color;
	}

	public float getDiameter() {
		return diameter;
	}

	public void setDiameter(float diameter) {
		this.diameter = diameter;
	}

	private float diameter;

	@Override
	public void printColor() {
		System.out.println("color: " + color);

	}

	@Override
	public void printShape() {
		System.out.println("shape: " + diameter);

	}

	@Override
	public String toString() {
		return "Circle [color=" + color + ", diameter=" + diameter + "]";
	}

}
