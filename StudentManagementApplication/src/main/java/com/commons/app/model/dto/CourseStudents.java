package com.commons.app.model.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseStudents {

	private Integer courseId;
	private String courseName;
	private String description;
	private String courseType;
	private String duration;
	private String topics;
	
	List<StudentDTO> studentList = new ArrayList<>();
	
}
