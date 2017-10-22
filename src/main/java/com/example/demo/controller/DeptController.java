package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Dept;
import com.example.demo.model.Emp;
import com.example.demo.repository.DeptRepository;

@Controller
@RequestMapping("/demo")
public class DeptController {
	
	
	@Autowired
	private DeptRepository deptRepository;
	
	@RequestMapping(path = "depts", method = RequestMethod.GET )
	public @ResponseBody Iterable<Dept> getAllDepts() {
		
		return deptRepository.findAll();
	}

	
    @RequestMapping(path = "depts", method = RequestMethod.POST, consumes = {"application/JSON", "application/XML"})
	public @ResponseBody Dept add (@RequestBody Dept dept) {
    	return deptRepository.save(dept);
    }
	
}
