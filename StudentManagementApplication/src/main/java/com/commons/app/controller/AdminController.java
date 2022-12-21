package com.commons.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.commons.app.exception.AdminExcepttion;
import com.commons.app.exception.UserException;
import com.commons.app.model.dto.UserDTO;
import com.commons.app.service.UserService;


@RestController
public class AdminController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/admin/register")
	public ResponseEntity<UserDTO> registerAdminHandler(@Valid @RequestBody UserDTO userDTO	) throws AdminExcepttion, UserException {
		
		UserDTO registeredUser =  userService.registerUser(userDTO) ;
		
		return new ResponseEntity<UserDTO>(registeredUser,HttpStatus.CREATED) ;
	}
	
	
}
