package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Dept;
import com.example.demo.model.Emp;
import com.example.demo.repository.EmpRepository;

@Controller
@RequestMapping("/demo")
public class EmpController {
	
	@Autowired
	EmpRepository empRepo;

	@RequestMapping("/emps")
	public @ResponseBody Iterable<Emp> findAllEmp() {
		
		return empRepo.findAll();
	}
	
	@RequestMapping("/emps/{ename}")
	public @ResponseBody Emp findByName(@PathVariable(value = "ename") String name ) {
		return empRepo.findEmpByEname(name);
	}
	
	
//	@RequestMapping("/emps/")
//	public @ResponseBody Emp findByName2(@RequestParam(value = "ename") String name ) {
//		return empRepo.findEmpByEname(name);
//	}
	
	@RequestMapping("/emps/{job}/{comm}")
	public @ResponseBody List<Emp> findByJobComm(@PathVariable(value = "job") String job, @PathVariable(value="comm") float comm ) {
		return empRepo.findByJobAndComm(job, comm);
	}
}
