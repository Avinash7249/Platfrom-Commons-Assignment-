package com.commons.app.service;

import java.util.List;

import com.commons.app.exception.CourseException;
import com.commons.app.exception.StudentException;
import com.commons.app.model.dto.CourseDTO;
import com.commons.app.model.dto.CourseStudents;
import com.commons.app.model.dto.StudentCourse;

public interface CourseService {

	public CourseDTO addCourse(CourseDTO courseDTO) throws CourseException;
	
	public StudentCourse assignCourseToStudent(Integer studentId,Integer courseId) throws CourseException, StudentException;
	
	public CourseStudents getStudentsFromCourse(Integer courseId) throws CourseException;
	
	public List<CourseDTO> getCoursesByTopic(String topicName) throws CourseException;
	
	public CourseDTO removeCourse(Integer courseId) throws CourseException;
	
	
}
