package com.in28minutes.jpa.hibernate.demo.entity1;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Mobile
{
	@Id
	private long id;
	
	private String brand;

	public Mobile() {
		super();
	}

	public Mobile(String brand) {
		super();
		this.brand = brand;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Mobile [id=" + id + ", brand=" + brand + "]";
	}
	
	

}
