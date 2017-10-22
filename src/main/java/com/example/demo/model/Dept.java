package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dept {
	
	@Id
 	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "deptno")
	private Long dept;
	private String dname;
	private String loc;
	public Dept(Long dept, String dname, String loc) {
		super();
		this.dept = dept;
		this.dname = dname;
		this.loc = loc;
	}
	
	public Dept() {
		
		
	}
	public Long getDept() {
		return dept;
	}
	public String getDname() {
		return dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setDept(Long dept) {
		this.dept = dept;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	@Override
	public String toString() {
		return "Dept [dept=" + dept + ", dname=" + dname + ", loc=" + loc + "]";
	}

}
