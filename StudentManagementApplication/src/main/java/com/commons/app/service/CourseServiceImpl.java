package com.commons.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commons.app.exception.CourseException;
import com.commons.app.exception.StudentException;
import com.commons.app.model.Course;
import com.commons.app.model.Student;
import com.commons.app.model.dto.CourseDTO;
import com.commons.app.model.dto.CourseStudents;
import com.commons.app.model.dto.StudentCourse;
import com.commons.app.model.dto.StudentDTO;
import com.commons.app.repo.CourseRepo;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepo courseRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private StudentService studentService;
	
	@Override
	public CourseDTO addCourse(CourseDTO courseDTO) throws CourseException {
			
		Course course = dtoToCourse(courseDTO);
		course = courseRepo.save(course) ;
		
		return courseToDTO(course);
	}

	@Override
	public StudentCourse assignCourseToStudent(Integer studentId, Integer courseId) throws CourseException, StudentException {
		
		Course course =  courseRepo.findById(courseId).orElseThrow(()-> new CourseException("Invalid CourseId "+ courseId)) ;
		Student student = studentService.getStudentById(studentId);
				
		course.getStudents().add(student);
		Course updatedCourseDetails = courseRepo.save(course);
		
		List<Course> studentCourses =  studentService.getAllCoursesAdminPurpose(studentId);
		
		StudentCourse studentCourseDetails = studentService.coursesToStudentCourse(studentCourses, student);
		
		return studentCourseDetails;
	}
	
	
	@Override
	public CourseStudents getStudentsFromCourse(Integer courseId) throws CourseException {
		
		Course course =  courseRepo.findById(courseId).orElseThrow(()-> new CourseException("Invalid CourseId "+ courseId)) ;
		
		if(course.getStudents().isEmpty()) 
			throw new CourseException("No students are present in the Course: " + course.getCourseName()) ;
		
		List<Student> students = course.getStudents();
		List<StudentDTO> studentDTOs = students.stream()
				.map(student -> this.studentToDTO(student)).collect(Collectors.toList()) ;
		
		CourseStudents courseStudents = new CourseStudents();
		BeanUtils.copyProperties(course, courseStudents);
		courseStudents.setStudentList(studentDTOs);
		
		return courseStudents;
	}
	
	@Override
	public List<CourseDTO> getCoursesByTopic(String topicName) throws CourseException {
		
		List<Course> courses = courseRepo.getCoursesByTopic(topicName);
		List<CourseDTO> dtoList = new ArrayList<>();
		
		dtoList =  courses.stream().map(course -> courseToDTO(course)).collect(Collectors.toList()) ;
 		return dtoList;
	}
	
	
	@Override
	public CourseDTO removeCourse(Integer courseId) throws CourseException {
		
		Course course =  courseRepo.findById(courseId).orElseThrow(()-> new CourseException("Invalid CourseId: "+courseId)) ;
		
		courseRepo.delete(course);
		
		return courseToDTO(course);
	}
	
	
	public Course dtoToCourse(CourseDTO courseDTO) {
		return this.modelMapper.map(courseDTO, Course.class);
	}
	
	public CourseDTO courseToDTO(Course course) {
		return this.modelMapper.map(course, CourseDTO.class);
	}
	
	public StudentDTO studentToDTO(Student student) {
		return this.modelMapper.map(student, StudentDTO.class);
	}

}













