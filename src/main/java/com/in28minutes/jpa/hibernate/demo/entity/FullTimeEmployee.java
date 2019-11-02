package com.in28minutes.jpa.hibernate.demo.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class FullTimeEmployee extends Employees
{
	private BigDecimal salary;

	public FullTimeEmployee() {
		super();
	}

	public FullTimeEmployee(String name, BigDecimal salary) {
		super(name);
		this.salary = salary;
	}
	
	public BigDecimal getsalary() {
		return salary;
	}

	public void setsalary(BigDecimal salary) {
		this.salary = salary;

}
}
