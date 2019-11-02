package com.in28minutes.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoApplication.class)
public class NamedQuery 
{
	@Autowired
	EntityManager em;
	@Test
	public List<Course> jpqlTest()
	{
		TypedQuery<Course> rs = em.createQuery("Select c from Course c", Course.class);
		List<Course> rsl = rs.getResultList();
		return rsl;
		
	}

}
