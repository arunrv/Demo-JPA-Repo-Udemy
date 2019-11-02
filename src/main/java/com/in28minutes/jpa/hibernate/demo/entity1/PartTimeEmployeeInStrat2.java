package com.in28minutes.jpa.hibernate.demo.entity1;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class PartTimeEmployeeInStrat2 extends EmployeesInStrat2 
{
	private BigDecimal hourlyWage;

	public PartTimeEmployeeInStrat2() {
		super();
	}

	public PartTimeEmployeeInStrat2(String name, BigDecimal hourlyWage) {
		super(name);
		this.hourlyWage = hourlyWage;
	}
	
	public BigDecimal getHourlyWage() {
		return hourlyWage;
	}

	public void setHourlyWage(BigDecimal hourlyWage) {
		this.hourlyWage = hourlyWage;
	}

	@Override
	public String toString() {
		return "PartTimeEmployeeInStrat2 [hourlyWage=" + hourlyWage + ", getId()=" + getId() + ", getName()="
				+ getName() + "]";
	}

}
