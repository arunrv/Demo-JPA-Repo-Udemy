package com.in28minutes.jpa.hibernate.demo;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.IsInstanceOf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.entity.Employee;
import com.in28minutes.jpa.hibernate.demo.entity.Review;
import com.in28minutes.jpa.hibernate.demo.entity.Student;
import com.in28minutes.jpa.hibernate.demo.entity1.AppleMobile;
import com.in28minutes.jpa.hibernate.demo.entity1.EmployeesInStrat2;
import com.in28minutes.jpa.hibernate.demo.entity1.FullTimeEmployeeInStrat2;
import com.in28minutes.jpa.hibernate.demo.entity1.PartTimeEmployeeInStrat2;
import com.in28minutes.jpa.hibernate.demo.entity1.SamsungMobile;
import com.in28minutes.jpa.hibernate.demo.repository.CourseRepository;
import com.in28minutes.jpa.hibernate.demo.repository.DepartmentRepository;
import com.in28minutes.jpa.hibernate.demo.repository.EmployeeRepository;
import com.in28minutes.jpa.hibernate.demo.repository.EmployeeRepositoryInheritance;
import com.in28minutes.jpa.hibernate.demo.repository.EmployeeRepositoryInheritanceType2;
import com.in28minutes.jpa.hibernate.demo.repository.MobileRepository;
import com.in28minutes.jpa.hibernate.demo.repository.StudentRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository course_repository;
	
	@Autowired
	private StudentRepository repository1;
	
	@Autowired
	private EmployeeRepository empRepository;
	
	@Autowired
	private DepartmentRepository deptRepistory;
	
	@Autowired
	private StudentRepository srepo;
	
	@Autowired
	private EmployeeRepositoryInheritance emprepo;
	
	@Autowired
	private EmployeeRepositoryInheritanceType2 emprepo2;
	
	@Autowired
	private MobileRepository mobrepo;


	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		/*Course course = repository.findById(10001L);
		logger.info("Course 10001 -> {}", course);
		repository.save(new Course("Microservices in 100 Steps"));
		logger.info("searching the student by ID");
		Student st1 = repository1.findBy(1100L);
		logger.info("Student 1001", st1);
		logger.info("Saving Student Object");
		Student S=new Student();
		S.setAge(10);
		S.setName("Shweetha");
		S.setPercent(60.5);
		repository1.save(S);
		logger.info("updating the student object");
		Student S1=new Student();
		S1.setId(1103L);
		S1.setAge(10);
		S1.setName("Arun");
		S1.setPercent(97);
		repository1.save(S1);*/
	/*	Employee e1 = empRepository.findByID(106732L);
		logger.info("The Employe with EID 106732L is "+e1);
		//Employee e2 = empRepository.findByName("Shweetha");
		//logger.info("Shweeth's details are ", e2);
		Employee e3=new Employee(100100L, "SriLakshmi", 100000, "Finance");
		empRepository.save(e3);//create
		Employee e4=new Employee(106735l, "Jamuna", 30000, "Junior Engineer");
		empRepository.update(e4);
		empRepository.deleteByID(106732l);*/
		course_repository.playWithEntityManager2();
		List<Course> r = course_repository.jpqlTest();
		List<Course> r1 = course_repository.jpqlTest1();
		logger.info("JPQL Query Result"+"is"+" "+r1);
		List list2 = course_repository.nativeQuery();
		logger.info("Value is", list2);
		//empRepository.storeDepartments();
		//srepo.saveStudentWithPassport();
		empRepository.playwithInitialization();
		empRepository.deptToEmployeeTraverse(99L);
		srepo.someTest();
		course_repository.addReviewsForCourse();
		//course_repository.addCourseAndSetReview();
		//List<Review> l1=new ArrayList<>();
		//l1.add(new Review("3.9", "Trainer is bit fast"));
		//l1.add(new Review("3.8", "Trainer doesnot teach basics"));
		//course_repository.addReviewsForCourse(10003L, l1);
		
		repository1.manyToManyTest();
		repository1.findManyToOne();
		emprepo.InheritanceTest1();
		
		logger.info("The Employee details are--------"+emprepo.retrieveAllEmployees());
		
		emprepo2.InheritanceTest2();
		
		logger.info("The Employee details are--------"+emprepo2.retrieveAllEmployees());
		List<EmployeesInStrat2> list = emprepo2.retrieveAllEmployees();
		for (EmployeesInStrat2 employeesInStrat2 : list) 
		{
			if (employeesInStrat2 instanceof PartTimeEmployeeInStrat2)
			{
				PartTimeEmployeeInStrat2 value = (PartTimeEmployeeInStrat2)employeesInStrat2;
				logger.info("The hourly wage of the employee is"+"-------------"+value.getHourlyWage());
			}
			else
			{
				FullTimeEmployeeInStrat2 value = (FullTimeEmployeeInStrat2)employeesInStrat2;
				logger.info("The hourly wage of the employee is"+"-------------"+value.getsalary());
			}
			
		}
		mobrepo.testMobilesInheritance();
		List<AppleMobile> applelist = mobrepo.getAppleMobileList();
		List<SamsungMobile> samlist = mobrepo.getSamMobileList();
		logger.info("The list of mobiles are"+applelist+"--------"+samlist);
		for (AppleMobile appleMobile : applelist) {
			logger.info("The apple mobile prices are"+"-------------"+appleMobile.getPrice());
			
		}
		
	}	
}
