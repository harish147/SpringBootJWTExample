package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.entity.UserRole;
import com.java.repository.UserRoleRepository;
import java.util.List;

@Service
public class UserRoleService {

	@Autowired
	private UserRoleRepository userRoleRepository;

	public UserRole createUserRole(UserRole userRole) {
		return userRoleRepository.save(userRole);
	}

	public List<UserRole> getAllUserRoles() {
		return userRoleRepository.findAll();
	}
	
	public UserRole getUserRoleByRole(String role){
		return userRoleRepository.findByRole(role);
	}
}
