package com.commons.app.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	
	private Integer userId;
	
	@NotNull(message = "Name cannot be Null")
	@NotBlank(message = "Name cannot be blank")
	@NotEmpty(message = "Name cannot be empty")
	@Size(min = 2,max = 30,message = "name size should be of 2-30")
	private String name;
	
	@Pattern(regexp = "[6-9][0-9]{9}",message = "Mobile number should start with 6-9 and of size 10")
	private String mobileNumber;
	
	private String password;
	
	@NotNull(message = "role cannot be Null")
	@NotBlank(message = "role cannot be blank")
	@NotEmpty(message = "role cannot be empty")
	private String role;
	
	public UserDTO(String name, String mobileNumber, String password) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.password = password;
	}
	
	
	
}
