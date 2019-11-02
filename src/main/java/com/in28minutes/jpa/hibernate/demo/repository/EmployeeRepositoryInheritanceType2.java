package com.in28minutes.jpa.hibernate.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.hibernate.demo.entity.Employees;
import com.in28minutes.jpa.hibernate.demo.entity.FullTimeEmployee;
import com.in28minutes.jpa.hibernate.demo.entity.PartTimeEmployee;
import com.in28minutes.jpa.hibernate.demo.entity1.EmployeesInStrat2;
import com.in28minutes.jpa.hibernate.demo.entity1.FullTimeEmployeeInStrat2;
import com.in28minutes.jpa.hibernate.demo.entity1.PartTimeEmployeeInStrat2;

@Repository
@Transactional
public class EmployeeRepositoryInheritanceType2 
{
	@Autowired
	EntityManager em;
	
	public void insert(EmployeesInStrat2 emp)
	{
		em.persist(emp);
	}
	
	public List<EmployeesInStrat2> retrieveAllEmployees()
	{
		List<EmployeesInStrat2> employeeslist = em.createQuery("select e from EmployeesInStrat2 e", EmployeesInStrat2.class).getResultList();
		return employeeslist;
	}
	
		
	public void InheritanceTest2()
	{
		EmployeesInStrat2 e1=new FullTimeEmployeeInStrat2("Jack", new BigDecimal("10000"));
		EmployeesInStrat2 e2=new PartTimeEmployeeInStrat2("Jill", new BigDecimal("500"));
		insert(e1);
		insert(e2);
	}

}