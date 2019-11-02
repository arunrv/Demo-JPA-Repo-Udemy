package com.in28minutes.jpa.hibernate.demo.entity1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class EmployeesInStrat2 
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
	
	

	public EmployeesInStrat2() {
		super();
	}

	public EmployeesInStrat2(String name) {
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
