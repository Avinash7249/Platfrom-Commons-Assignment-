package com.commons.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.commons.app.enums.AddressType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressId;
	
	@NotNull(message = "area cannot be Null")
	@NotBlank(message = "area cannot be blank")
	@NotEmpty(message = "area cannot be empty")
	private String area;
	
	@NotNull(message = "city cannot be Null")
	@NotBlank(message = "city cannot be blank")
	@NotEmpty(message = "city cannot be empty")
	private String city;
	
	@NotNull(message = "state cannot be Null")
	@NotBlank(message = "state cannot be blank")
	@NotEmpty(message = "state cannot be empty")
	private String state;
	
	@NotNull(message = "district cannot be Null")
	@NotBlank(message = "district cannot be blank")
	@NotEmpty(message = "district cannot be empty")
	private String district;
	
	@NotNull(message = "pincode cannot be Null")
	@NotBlank(message = "pincode cannot be blank")
	@NotEmpty(message = "pincode cannot be empty")
	private String pincode;
	
//	@NotNull(message = "addressType cannot be Null")
	private AddressType addressType;
	
}
