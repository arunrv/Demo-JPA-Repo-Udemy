package com.in28minutes.jpa.hibernate.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.hibernate.demo.entity.Course;

//@Repository
public interface CourseSpringDataRepository extends JpaRepository<Course, Long>
{
           Optional<Course> findByName(String name);
           Optional<List<Course>> findAllByNameOrderByCreationDate(String name);
}
