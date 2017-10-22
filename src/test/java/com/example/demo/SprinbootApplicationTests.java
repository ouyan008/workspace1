package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.example.demo.controller.DeptController;
import com.example.demo.repository.EmpRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SprinbootApplicationTests {
	
	
	@Autowired
	private DeptController deptController;
	
	@Autowired
    private RestTemplate restTemplate;

	@Autowired
	private EmpRepository empRepo;

	@Test
	@Ignore
	public void contextLoads() throws Exception {
		System.out.println(restTemplate + "====================================");
		
//		String str = restTemplate.getForObject("http://localhost:8080/demo/depts", String.class);
		String str = restTemplate.getForObject("http://localhost:8080/demo/depts", String.class);
		System.out.println(str + "****************************");
		//assertThat(deptController).isNotNull();
	}

	@Test
	@Ignore
	public void testFindEmpByName()  {
		
//		String str = restTemplate.getForObject("http://localhost:8080/demo/emps/smith", String.class);
		String str = restTemplate.getForObject("http://localhost:8080/demo/emps?ename=smith", String.class);
		System.out.println(str + "****************************");
	}
	
	@Test
	@Ignore
	public void testFindByJobandComm() {
		String str = restTemplate.getForObject("http://localhost:8080/demo/emps/salesman/300.00", String.class);
		System.out.println(str + "****************************");
	}

	@Test
	public void testFindEmpOrderBySal() {
		System.out.println(empRepo.findByhiredateAfter(new Date(1980, 1, 1)));
	}
	
}
