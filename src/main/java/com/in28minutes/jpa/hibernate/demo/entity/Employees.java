package com.in28minutes.jpa.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="EmployeeType")

@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Employees
{
	@Override
	public String toString() {
		return "Employees [id=" + id + ", name=" + name + "]";
	}

	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="EmployeeName")
	private String name;
	
	

	public Employees() {
		super();
	}

	public Employees(String name) {
		super();
		this.name = name;
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
	

}
