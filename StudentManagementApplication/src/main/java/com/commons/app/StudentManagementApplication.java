package com.commons.app;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.commons.app.model.User;
import com.commons.app.repo.UserRepo;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class StudentManagementApplication implements CommandLineRunner{

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}


	@Bean
	public ModelMapper modelMapper() {
        return new ModelMapper();
    }


	//for practice
	@Override
	public void run(String... args) throws Exception {
		
		User user=new User();
		user.setName("Avinash");
		user.setMobileNumber("7249249505");
		user.setRole("ROLE_ADMIN");
		user.setPassword(this.bCryptPasswordEncoder.encode("abc"));
		user.setUserId(1);
		
		this.userRepo.save(user);
	}

}
