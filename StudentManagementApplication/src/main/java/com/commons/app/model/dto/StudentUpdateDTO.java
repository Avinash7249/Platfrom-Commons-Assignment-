package com.commons.app.model.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import com.commons.app.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentUpdateDTO {
	
	private Integer studentId;
	private LocalDate dob;
	
	@Email(message = "Please enter a valid email")
	private String newEmail;
	
	@Pattern(regexp = "[6-9][0-9]{9}",message = "Mobile number should start with 6-9 and of size 10")
	private String newMobileNumber;
	
	
}
