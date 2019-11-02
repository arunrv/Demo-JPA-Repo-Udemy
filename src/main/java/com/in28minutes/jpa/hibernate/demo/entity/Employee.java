package com.in28minutes.jpa.hibernate.demo.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Employee 
{
	@Id
	long id;
	String name;
	double sal;
	String dept;
	@OneToOne(fetch = FetchType.LAZY)
	Department deptdetails;
	
	public Employee() {
	}
	
	
	public Employee(long id, String name, double sal, String dept) {
		super();
		this.id = id;
		this.name = name;
		this.sal = sal;
		this.dept = dept;
	}


	public Department getDeptdetails() {
		return deptdetails;
	}
	public void setDeptdetails(Department deptdetails) {
		this.deptdetails = deptdetails;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", sal=" + sal + ", dept=" + dept + "]";
	}
	

}
