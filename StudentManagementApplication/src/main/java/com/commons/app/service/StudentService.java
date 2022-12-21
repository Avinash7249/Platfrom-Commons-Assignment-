package com.commons.app.service;

import java.util.List;

import com.commons.app.exception.CourseException;
import com.commons.app.exception.StudentException;
import com.commons.app.exception.UserException;
import com.commons.app.model.Course;
import com.commons.app.model.Student;
import com.commons.app.model.dto.StudentAddressDTO;
import com.commons.app.model.dto.StudentCourse;
import com.commons.app.model.dto.StudentDTO;
import com.commons.app.model.dto.StudentUpdateDTO;

public interface StudentService {

	public StudentDTO registerStudent(StudentDTO studentDTO) throws StudentException, UserException;
	
	public Student getStudentById(Integer studentId) throws StudentException ;
	
	public List<Course> getAllCoursesAdminPurpose(Integer studentId) throws StudentException ;
	
	public List<StudentDTO> getStudentByName(String name) throws StudentException;
	
	public StudentDTO updateEmailAndMobile(StudentUpdateDTO dto) throws StudentException;
	
	public StudentDTO updateStudentAddress(StudentAddressDTO addressDTO) throws StudentException;
	
	public StudentCourse getStudentCourses(Integer studentId,String dateOfBirth) throws StudentException;
	
	public StudentCourse leaveCourse(Integer studentId,String dateOfBirth,Integer courseId) throws StudentException, CourseException;
	
	public StudentCourse coursesToStudentCourse(List<Course> courses,Student student) ;
	
	public StudentDTO addNewAddress(StudentAddressDTO addressDTO) throws StudentException;
}
