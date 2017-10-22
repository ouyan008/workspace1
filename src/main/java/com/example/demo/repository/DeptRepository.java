package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Dept;

public interface DeptRepository extends CrudRepository<Dept, Long> {
	
	
	

}
