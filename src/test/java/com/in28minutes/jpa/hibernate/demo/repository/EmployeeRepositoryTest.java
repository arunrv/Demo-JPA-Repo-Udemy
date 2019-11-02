package com.in28minutes.jpa.hibernate.demo.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Employee;

import junit.framework.Assert;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class EmployeeRepositoryTest 
{
	@Autowired
	EmployeeRepository empr;
	
	@Test
	public void findBy_EmployeeTest()
	{
		Employee e1 = empr.findByID(106730l);
		Assert.assertEquals("Reeta", e1.getName());
	}
	@Test
	public void Save_EmployeeTest()
	{
		Employee e2=new Employee(1100l, "Raju", 50000, "IT");
		empr.save(e2);
		Employee e3 = empr.findByID(1100l);
		Assert.assertEquals("Raju", e3.getName());
	}
	

}
