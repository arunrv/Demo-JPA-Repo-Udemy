package com.in28minutes.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.hibernate.demo.entity.Department;
import com.in28minutes.jpa.hibernate.demo.entity.Employee;

@Repository
public class DepartmentRepository 
{
	@Autowired
	EntityManager em;
	
	public Department findById(Long id)
	{
		return em.find(Department.class, id);
	}
	
	public void save(Department dept)
	{
		em.persist(dept);
	}
	public void update(Department dept)
	{
		em.merge(dept);
	}
	public void delete(Long id)
	{
		Department dept = findById(id);
		em.remove(dept);
	}
	

}
