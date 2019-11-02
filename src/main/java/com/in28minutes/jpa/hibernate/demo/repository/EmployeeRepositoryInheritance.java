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

@Repository
@Transactional
public class EmployeeRepositoryInheritance 
{
	@Autowired
	EntityManager em;
	
	public void insert(Employees emp)
	{
		em.persist(emp);
	}
	
	public List<Employees> retrieveAllEmployees()
	{
		List<Employees> employeeslist = em.createQuery("select e from Employees e", Employees.class).getResultList();
		return employeeslist;
	}
	
	public Employees findById(Long id)
	{
		return em.find(Employees.class, id);
	}
	
	public void InheritanceTest1()
	{
		Employees e1=new FullTimeEmployee("Jack", new BigDecimal("10000"));
		Employees e2=new PartTimeEmployee("Jill", new BigDecimal("500"));
		insert(e1);
		insert(e2);
	}

}
