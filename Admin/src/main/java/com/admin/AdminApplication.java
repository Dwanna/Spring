package com.admin;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import com.admin.domain.User;
import com.admin.domain.security.Role;
import com.admin.domain.security.UserRole;
import com.admin.service.impl.UserService;
import com.admin.utility.SecurityUtility;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class AdminApplication implements CommandLineRunner{

	@Autowired
	private UserService userservice;
	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
	
		
			User user1= new User();
			
			user1.setUsername("Admin");
			user1.setPassword(SecurityUtility.passwordEncoder().encode("Admin"));
			user1.setEmail("Admin@gmail.com");
			
			Set<UserRole> userRoles= new HashSet<>();
			Role role1= new Role();
			role1.setRoleId(0);
			role1.setName("ROLE_ADMIN");
			userRoles.add(new UserRole(user1,role1));
			
			userservice.createUser(user1,userRoles);
	}

}
