package com.in28minutes.jpa.hibernate.demo.entity1;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class FullTimeEmployeeInStrat2 extends EmployeesInStrat2
{
	@Override
	public String toString() {
		return "FullTimeEmployeeInStrat2 [salary=" + salary + ", getId()=" + getId() + ", getName()=" + getName() + "]";
	}

	private BigDecimal salary;

	public FullTimeEmployeeInStrat2() {
		super();
	}

	public FullTimeEmployeeInStrat2(String name, BigDecimal salary) {
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
