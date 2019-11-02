package com.in28minutes.jpa.hibernate.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="CourseDetails")
@NamedQueries(value= {
		@NamedQuery(name="query1", query="select c from Course c"),
		@NamedQuery(name="query2", query="select c from Course c where id like '%10%'")
})
public class Course {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name="FullName")
	private String name;

	@CreationTimestamp
	@Column(name="CreationDate")
	private LocalDateTime creationDate;
	
	@UpdateTimestamp
	@Column(name="UpdatedDate")
	private LocalDateTime updatedDate;
	
	

	@OneToMany(mappedBy="course", cascade=CascadeType.ALL)
	private List<Review> reviews=new ArrayList<>();
	
	@ManyToMany(mappedBy="courses")
	List<Student> students=new ArrayList<>();
	
	public List<Student> getStudent_list() {
		return students;
	}

	public void setStudent_list(List<Student> student_list) {
		this.students = student_list;
	}
	
	public void setStudent(Student student)
	{
		this.students.add(student);
	}

	public List<Review> getReviews() {
		return reviews;
	}
	
	public void addReview(Review r)
	{
		reviews.add(r);
	}
	public void deleteReview(Review r)
	{
		reviews.remove(r);
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	protected Course() {
	}

	public Course(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	
	

	@Override
	public String toString() {
		return String.format("Course[%s]", name);
	}
}