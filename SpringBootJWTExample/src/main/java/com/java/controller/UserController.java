package com.java.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.dto.request.UserRequestDto;
import com.java.entity.User;
import com.java.service.UserRoleService;
import com.java.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping
	public ResponseEntity<List<User>> getAllUser() {
		return ResponseEntity.ok(userService.getAllUsers());
	}

	@GetMapping("/{username}")
	public ResponseEntity<User> getUserByUserName(@PathVariable String userName) {
		return ResponseEntity.ok(userService.getUserByEmail(userName));
	}

	@PostMapping
	public ResponseEntity<User> createNewUser(@RequestBody UserRequestDto userRequestDto) {
		User user = new User();
		user.setRoles(userRequestDto.getRoles().stream().map(role-> userRoleService.getUserRoleByRole(role)).collect(Collectors.toSet()));
		System.out.println(user.getRoles());
		user.setFirstName(userRequestDto.getFirstName());
		user.setMiddleName(userRequestDto.getMiddleName());
		user.setLastName(userRequestDto.getLastName());
		user.setMobileNumber(userRequestDto.getMobileNumber());
		user.setEmailId(userRequestDto.getEmailId());
		user.setAddress(userRequestDto.getAddress());
		user.setCity(userRequestDto.getCity());
		user.setState(userRequestDto.getState());
		user.setContry(userRequestDto.getContry());
		user.setPassword(bCryptPasswordEncoder.encode(userRequestDto.getPassword()));
		return ResponseEntity.ok(userService.saveUser(user));
	}

	@PutMapping
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		return ResponseEntity.ok(userService.saveUser(user));
	}

	@PatchMapping
	public ResponseEntity<User> patchUser(@RequestBody User user) {
		return ResponseEntity.ok(userService.patchUser(user));
	}

	@DeleteMapping
	public ResponseEntity<Boolean> deleteUser(@RequestBody User user) {
		return ResponseEntity.ok(userService.deleteUser(user));
	}

}
