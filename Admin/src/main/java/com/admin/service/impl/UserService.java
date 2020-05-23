package com.admin.service.impl;

import java.util.Set;

import com.admin.domain.User;
import com.admin.domain.security.PasswordResetToken;
import com.admin.domain.security.UserRole;

public interface UserService {

	

	User createUser(User user, Set<UserRole> userRoles) throws Exception;
	User save(User user);

}
