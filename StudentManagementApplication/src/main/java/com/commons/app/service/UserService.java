package com.commons.app.service;

import com.commons.app.exception.UserException;
import com.commons.app.model.dto.UserDTO;

public interface UserService {

	public UserDTO registerUser(UserDTO userDTO) throws UserException;
	
	public UserDTO registerStudentAsUser(UserDTO userDTO) throws UserException;
	
}
