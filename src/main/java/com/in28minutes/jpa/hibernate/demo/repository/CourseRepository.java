package com.in28minutes.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.entity.Review;
import com.in28minutes.jpa.hibernate.demo.entity.Student;

import ch.qos.logback.classic.Logger;

@Repository
@Transactional
public class CourseRepository {

	@Autowired
	EntityManager em;

	public Course findById(Long id) {
		return em.find(Course.class, id);
	}

	public Course save(Course course) {
		
		if (course.getId() == null) {
			em.persist(course);
		} else {
			em.merge(course);
		}
		
		return course;
	}

	public void deleteById(Long id) {
		Course course = findById(id);
		em.remove(course);
	}
	
	public void playWithEntityManager()
	{
		Course course1=new Course("MicroServices in 10 steps");
		em.persist(course1);
		em.flush(); // whatever transaction happened till here is saved to db. Changes upto this point is sent to db.
		
		em.detach(course1);
		course1.setName("MicreServices in 10 steps Updated");
		em.flush(); // whatever transaction happened till here is saved to db. Changes upto this point is sent to db.
		
		Course course2=new Course("Angular JS in 10 steps");
		em.persist(course2);
		em.flush();
		em.detach(course2);
		
		course2.setName("Angular JS in 10 steps - Updated"); // These details wont get saved to DB.
		em.flush();// Eventhough if you apply flush method the updated details wont go and store it in db.

	}
	
	public void playWithEntityManager1()
	{
		Course course1=new Course("MicroServices in 10 steps");
		em.persist(course1);
		//em.createQuery("select s from student s", Student.class).executeUpdate();
		 
		
		Course course2=new Course("Angular JS in 10 steps");
		em.persist(course2);
		
		em.flush();
		
		em.clear(); //entity Manager stops tracking.
		
		course1.setName("MicreServices in 10 steps Updated");
		em.flush(); //data wont get saved.
		
		
		course2.setName("Angular JS in 10 steps - Updated"); // These details wont get saved to DB.
		em.flush();// Eventhough if you apply flush method the updated details wont go and store it in db.

	}
	
	public void playWithEntityManager2()
	{
		Course course1=new Course("MicroServices in 10 steps");
		em.persist(course1);
		
		Course course2=new Course("Angular JS in 10 steps");
		em.persist(course2);
		
		em.flush();
		
		course1.setName("MicreServices in 10 steps Updated");
		course2.setName("Angular JS in 10 steps - Updated"); // These details wont get saved to DB.
		em.refresh(course1);//To remove all the changes done to course1 and get back the original details.
		em.flush();

	}
	public List<Course> jpqlTest()
	{
		TypedQuery<Course> rs = em.createQuery("Select c from Course c where id like '%10%'", Course.class);
		List<Course> rsl = rs.getResultList();
		return rsl;
		
	}
	public List<Course> jpqlTest1()
	{
		TypedQuery<Course> rs = em.createNamedQuery("query1", Course.class);
		List<Course> rsl = rs.getResultList();
		return rsl;
		
	}
	public List nativeQuery()
	{
		Query cnq = em.createNativeQuery("select * from course_details where id= :id", Course.class);
		cnq.setParameter("id", 10002L);
		List grl = cnq.getResultList();
		return grl;
       	
	}
	
	public void addReviewsForCourse()
	{
		//get the course with the id 1003
		Course course = findById(10003L);
		System.out.println("The Review is ------------->"+course.getReviews());
		
		//CREATE two reviews
		Review review1=new Review("5", "Super macha");
		Review review2=new Review("4", "HatsOff");
		
		//add the review to course
		
		review1.setCourse(course);
		//course.addReview(review1);
		review2.setCourse(course);
		//course.addReview(review2);
		
		
		//save the review to the data base
		em.persist(review1);
		em.persist(review2);
		System.out.println("The course is----------->"+review1.getCourse());
		System.out.println("The review is----------->"+course.getReviews());
	}
	public void addReviewsForCourse(Long cid, List<Review> review)
	{
		//get the course with the id 1003
		Course course = findById(cid);
		System.out.println("The Review is ------------->"+course.getReviews());
		
		for(Review rev:review)
		{
			course.addReview(rev);
			rev.setCourse(course);
			em.persist(rev);
		}
		
	}
	public void addCourseAndSetReview()
	{
		Course course1 = findById(10003L);
		System.out.println("The updated set of reviews for this course are------->"+course1.getReviews());
		Course course2=new Course("Rest Assured API Testing");
		
		Review review1=new Review("3", "Twitter API not working");
		Review review2=new Review("4", "Still improvement required");
		
		course2.addReview(review1);
		review1.setCourse(course2);
		course2.addReview(review2);
		review2.setCourse(course2);
		
		em.persist(course2);
		em.persist(review1);
		em.persist(review2);
		
		
	}
	

}
