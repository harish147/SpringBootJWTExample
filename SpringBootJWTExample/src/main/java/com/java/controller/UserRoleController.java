package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.java.entity.UserRole;
import com.java.service.UserRoleService;

@RestController
@RequestMapping("/userrole")
public class UserRoleController {

	@Autowired
	private UserRoleService userRoleService;

	@GetMapping
	public ResponseEntity<List<UserRole>> getAllUserRoles() {
		return ResponseEntity.ok(userRoleService.getAllUserRoles());
	}

	@PostMapping
	public ResponseEntity<UserRole> createUserRole(@RequestBody UserRole userRole) {
		userRole.setRole("ROLE_" + userRole.getRole());
		return ResponseEntity.ok(userRoleService.createUserRole(userRole));
	}
}
