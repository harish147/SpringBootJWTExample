package com.java.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.java.entity.User;
import com.java.repository.UserRepository;

import jakarta.annotation.PostConstruct;
import lombok.Data;

@Service
@Data
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void init() {

	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserByEmail(String email) {
		Optional<User> optionalUser = userRepository.findByEmailId(email);
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			throw new UsernameNotFoundException("User with username: " + email + " Not Found");
		}
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public User patchUser(User user) {
		if (userRepository.exists(Example.of(user))) {
			return userRepository.save(user);
		} else {
			throw new UsernameNotFoundException("Update Failed!, User Not Found with userId: " + user.getEmailId());
		}

	}

	public boolean deleteUser(User user) {
		userRepository.delete(user);
		return true;
	}
}
