package com.commons.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.commons.app.model.User;
import com.commons.app.repo.UserRepo;



@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//fetching user from databse
		User user = userRepo.findByMobileNumber(username);
		
		if(user == null)
			throw new UsernameNotFoundException("Invalid MobileNumber provided") ;
		
		return new CustomUserDetails(user);
	}

}
