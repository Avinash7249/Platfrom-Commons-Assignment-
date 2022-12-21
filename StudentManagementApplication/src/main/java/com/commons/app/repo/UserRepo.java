package com.commons.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.commons.app.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	public User findByMobileNumber(String mobileNumber);
	
}
