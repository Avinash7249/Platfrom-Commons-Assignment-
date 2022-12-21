package com.commons.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.commons.app.model.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {

	@Query("from Course c where c.topics LIKE %:topic% OR c.courseName LIKE %:topic% ")
	public List<Course> getCoursesByTopic(String topic) ;
}
