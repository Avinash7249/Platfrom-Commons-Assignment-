package com.commons.app.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.commons.app.enums.AddressType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer courseId;

	private String courseName;
	private String description;
	private String courseType;
	private String duration;
	private String topics;
	
	@ManyToMany(cascade = CascadeType.ALL)
	List<Student> students = new ArrayList<>();

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", description=" + description
				+ ", courseType=" + courseType + ", duration=" + duration + ", topics=" + topics + "]";
	}
	
	
}

