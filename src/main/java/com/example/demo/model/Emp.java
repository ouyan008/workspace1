package com.example.demo.model;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Emp {
	
	private float comm;

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long empno;

	private String ename;
    @Temporal(TemporalType.DATE)
	private Date hiredate;

	private String job;

	private Long mgr;

	public Long getMgr() {
		return mgr;
	}
	private float sal;
	@ManyToOne
	@JoinColumn(name = "deptno")
	private Dept dept;

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public void setMgr(Long mgr) {
		this.mgr = mgr;
	}

	public float getComm() {
		return comm;
	}

	
	public Long getEmpno() {
		return empno;
	}

	public String getEname() {
		return ename;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public String getJob() {
		return job;
	}

	

	public float getSal() {
		return sal;
	}

	public void setComm(float comm) {
		this.comm = comm;
	}

	
	public void setEmpno(Long empno) {
		this.empno = empno;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	public void setSal(float sal) {
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "Emp [comm=" + comm + ", deptno=" +  ", empno=" + empno + ", ename=" + ename + ", hiredate="
				+ hiredate + ", job=" + job + ", mgr=" + mgr + ", sal=" + sal + "]";
	}

}
