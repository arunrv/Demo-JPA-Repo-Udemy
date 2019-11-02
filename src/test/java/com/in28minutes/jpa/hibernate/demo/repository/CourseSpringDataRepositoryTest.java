package com.in28minutes.jpa.hibernate.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class CourseSpringDataRepositoryTest 
{
	@Autowired
	CourseSpringDataRepository courserepo;
	
	@Test
	public void findById()
	{
		Optional<Course> course = courserepo.findById(10001L);
		if(course.isPresent())
		System.out.println("The course details is "+course);
		else
		System.out.println("The course is not present");
		
	}
	
	@Test
	public void addingUsingSpringDataJPAe()
	{
		Course c=new Course("Java 8 by durga Soft");
		courserepo.save(c);
		c.setName("Java 8 by durga Soft Updated");
		courserepo.save(c);
		List<Course> listCourse = courserepo.findAll();
		System.out.println(listCourse);
	}
	
	@Test
	public void customMethods()
	{
		Optional<Course> course = courserepo.findByName("Spring in 50 Steps");
		System.out.println(course);
		Optional<List<Course>> listcourse = courserepo.findAllByNameOrderByCreationDate("Spring Boot in 12 Steps");
		System.out.println(listcourse);
	}

}
