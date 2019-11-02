package com.in28minutes.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.entity.Passport;
import com.in28minutes.jpa.hibernate.demo.entity.Student;

@Repository
@Transactional
public class StudentRepository 
{
	@Autowired
	EntityManager em;
    public Student findBy(Long id)
    {
    	Student student = em.find(Student.class, id);
    	return student;
    	
    }
    public void remove(Long id)
    {
    	Student student = findBy(id);
    	em.remove(student);
    }
    public void save (Student student)
    {
    	if (student.getId()==null) 
    	{
			em.persist(student);
		} else {
			em.merge(student);
		}
    }
    public void saveStudentWithPassport() {
		Passport passport=new Passport("123456L");
		em.persist(passport);
		Student student=new Student("Janaki", 12, 99);
		student.setPassport(passport);
		em.persist(student);
			
	}
    public void someTest()
	{
		Student student = em.find(Student.class, 1100L);
		//After the above operation, Persistance context contains (student)
		Passport passport=student.getPassport();
		//Now persistance context contains (student and passport)
		System.out.println("The student is -------->"+student);
		System.out.println("The passport is -------->"+passport);
		passport.setNumber("E123456");
		//Now persistance context contains (student+ and passport)
		student.setName("Ranga");
		//Now persistance context contains (student+ and passport+)
		//em.merge(student);
		//after the execution of all the transaction statements the db changes are sent to the data base.Entire
		//query will be sent at the end of the transaction.
	}
	
    public void manyToManyTest()
    {
    	Student student=new Student("Jack", 23, 70);
    	Student student1=new Student("Mack", 23, 70);
    	
    	Course course=new Course("Python course");
    	Course course1=new Course("Test Course");
    	em.persist(student);
    	em.persist(student1);
    	em.persist(course);
    	em.persist(course1);
    	student.setCourse(course);
    	course.setStudent(student);
    	student1.setCourse(course);
    	course.setStudent(student1);
    	student.setCourse(course1);
    	course1.setStudent(student);
    }
    
    public void findManyToOne()
    {
    	Student student = em.find(Student.class, 5L);
    	List<Course> courselist = student.getCourse_list();
    	System.out.println("The student and course list is"+student.getId()+"------------"+courselist.size());
    	
    }

}
