package com.in28minutes.jpa.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Passport 
{

	@Id
	@GeneratedValue
	private Long id;
	public Passport(String number) {
		super();
		this.number = number;
	}
	@OneToOne(mappedBy="passport")
	private Student student;
	@Column(nullable=false)
	private String number;
	public Passport() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
}
