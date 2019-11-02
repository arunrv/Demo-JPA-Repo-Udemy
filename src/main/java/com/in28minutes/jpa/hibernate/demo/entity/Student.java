package com.in28minutes.jpa.hibernate.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Student 
{
	@Id
	@GeneratedValue
	Long id;
	
	String name;
	int age;

	@OneToOne
	private Passport passport;
	
	@ManyToMany
	@JoinTable(name="Student_Course", joinColumns=@JoinColumn(name="STUDENT_ID"), 
	inverseJoinColumns=@JoinColumn(name="COURSE_ID"))
	private List<Course> courses=new ArrayList<>();
	
	public List<Course> getCourse_list() {
		return courses;
	}


	public void setCourse_list(List<Course> course_list) {
		this.courses = course_list;
	}
	
	public void setCourse(Course course)
	{
		this.courses.add(course);
	}


	protected Student() {
	}

	
	public Student(String name, int age, double percent) {
		this.name = name;
		this.age = age;
		this.percent = percent;
	}

	public Passport getPassport() {
		return passport;
	}
	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	double percent;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getPercent() {
		return percent;
	}
	public void setPercent(double percent) {
		this.percent = percent;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", percent=" + percent + "]";
	}

}
