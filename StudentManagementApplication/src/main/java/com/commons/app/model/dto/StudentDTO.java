package com.commons.app.model.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.commons.app.enums.Gender;
import com.commons.app.model.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
	
	private Integer studentId;
	
	@NotNull(message = "name cannot be Null")
	@NotBlank(message = "name cannot be blank")
	@NotEmpty(message = "name cannot be empty")
	private String name;
	
	@NotNull(message = "fatherName cannot be Null")
	@NotBlank(message = "fatherName cannot be blank")
	@NotEmpty(message = "fatherName cannot be empty")
	private String fatherName;
	
	@Email(message = "Please enter valid emailId")
	private String email;
	
	@Pattern(regexp = "[6-9][0-9]{9}",message = "Mobile number should start with 6-9 and of size 10")
	private String mobileNumber;
	
	private LocalDate dob;
	
	@NotNull(message = "gender cannot be Null")
	private Gender gender;
	
	
	private List<Address> address = new ArrayList<>();
	
}
