package com.commons.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.commons.app.exception.AdminExcepttion;
import com.commons.app.exception.UserException;
import com.commons.app.model.User;
import com.commons.app.model.dto.UserDTO;
import com.commons.app.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UserDTO registerUser(UserDTO userDTO) throws UserException {
		
		if(userRepo.findByMobileNumber(userDTO.getMobileNumber()) != null) {
			throw new UserException("Mobile number is already Registred " + userDTO.getMobileNumber()) ;
		}
		
		userDTO.setRole("ROLE_"+userDTO.getRole());
		userDTO.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
		
		User user = dtoToUser(userDTO);
		user = userRepo.save(user);
		
		UserDTO registerUser = userToDTO(user);
		return registerUser;
		
	}
	
	public User dtoToUser(UserDTO userDTO) {
		return this.modelMapper.map(userDTO, User.class);
	}
	
	public UserDTO userToDTO(User user) {
		return this.modelMapper.map(user, UserDTO.class);
	}

	@Override
	public UserDTO registerStudentAsUser(UserDTO userDTO) throws UserException {
		
		if(userRepo.findByMobileNumber(userDTO.getMobileNumber()) != null) {
			throw new UserException("Mobile number is already Registred " + userDTO.getMobileNumber()) ;
		}
		userDTO.setRole("ROLE_NORMAL");
		
		User user = dtoToUser(userDTO);
		user = userRepo.save(user);
		
		UserDTO registerUser = userToDTO(user);
		return registerUser;
		
	}

	
	
}
