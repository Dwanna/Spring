package com.admin.service.impl;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.domain.User;
import com.admin.domain.security.UserRole;
import com.admin.repository.RoleRepository;
import com.admin.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	public User createUser(User user, Set<UserRole> userRoles) throws Exception {

		User localUser = userRepository.findByUsername(user.getUsername());

		if (localUser != null) {
			// throw new Exception("user already exist. Nothing will be done");
			LOG.info("user{} already exist.Nothing will be done" + user.getUsername());

		}

		else {
			for (UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);

			localUser = userRepository.save(user);
		}

		return localUser;
	}
	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

}
