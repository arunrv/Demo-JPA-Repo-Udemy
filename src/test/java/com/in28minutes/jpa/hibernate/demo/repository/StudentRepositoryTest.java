package com.in28minutes.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Passport;
import com.in28minutes.jpa.hibernate.demo.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class StudentRepositoryTest
{
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository studentrepository;
	
	@Autowired
	EntityManager em;
	
	@Test
	@Transactional
	public void someTest()
	{
		Student student = em.find(Student.class, 1100L);
		//After the above operation, Persistance context contains (student)
		Passport passport=student.getPassport();
		//Now persistance context contains (student and passport)
		logger.info("The student is -------->", student);
		logger.info("The passport is -------->", passport);
		passport.setNumber("E123456");
		//Now persistance context contains (student+ and passport)
		student.setName("Ranga");
		//Now persistance context contains (student+ and passport+)
		em.merge(student);
		//after the execution of all the transaction statements the db changes are sent to the data base.Entire
		//query will be sent at the end of the transaction.
	}

}
