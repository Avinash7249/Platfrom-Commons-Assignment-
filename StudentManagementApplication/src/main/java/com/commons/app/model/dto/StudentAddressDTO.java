package com.commons.app.model.dto;

import java.time.LocalDate;

import com.commons.app.model.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentAddressDTO {

	private Integer studentId;
	private LocalDate dob;
	private Address address;
}
