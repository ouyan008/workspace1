package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Emp;

public interface EmpRepository extends JpaRepository<Emp, Long> {
	
	public Emp findEmpByEname(String ename);
	
	public List<Emp> findByJobAndComm(String job, float comm);
	
	public List<Emp> findByhiredateAfter(Date date);
	

}
