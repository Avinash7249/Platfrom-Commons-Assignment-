package com.commons.app.model.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentCourse {

	private Integer StudentId;
	private String name;
	
	private List<CourseDTO> courses = new ArrayList<>();
	
}
