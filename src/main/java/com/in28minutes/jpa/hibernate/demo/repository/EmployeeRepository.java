package com.in28minutes.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.hibernate.demo.entity.Department;
import com.in28minutes.jpa.hibernate.demo.entity.Employee;
import com.in28minutes.jpa.hibernate.demo.entity.Passport;
import com.in28minutes.jpa.hibernate.demo.entity.Student;

import ch.qos.logback.classic.Logger;

@Repository
@Transactional
public class EmployeeRepository 
{
	@Autowired
	EntityManager em;
	
	public Employee findByID(long id)
	{
		Employee e = em.find(Employee.class, id);
		return e;
	}
	public Employee findByName(String name)
	{
		return em.find(Employee.class, name);
	}
	public void deleteByID(long id)
	{
		Employee e1 = findByID(id);
		em.remove(e1);
	}
	public void save(Employee emp)
	{
		em.persist(emp);
	}
	public void update(Employee emp)
	{
		em.merge(emp);
	}
	@Transactional
	public void storeDepartments()
	{
		Department dept=new Department();
		dept.setDname("Testname");
		dept.setLoc("TestLoc");
		em.persist(dept);
		Employee emp=new Employee();
		emp.setName("TestEmployee");
		emp.setDept("Army");
		emp.setSal(100000);
		emp.setDeptdetails(dept);
		emp.setId(10L);
		em.persist(emp);
	}
	
	public void playwithInitialization()
	{
		Employee emp = findByID(106731L);
		System.out.println("The details are  ------>"+emp.getDeptdetails());
	}
	
	public void deptToEmployeeTraverse(long did)
	{
		Department dept=em.find(Department.class, did);
		System.out.println("The Employee details are----------> "+dept.getEmp());
	}
	

}
