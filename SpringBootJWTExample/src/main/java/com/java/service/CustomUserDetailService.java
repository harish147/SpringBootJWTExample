package com.java.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.java.config.CustomUserDetail;
import com.java.entity.User;
import com.java.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public CustomUserDetail loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> optionalUser = userRepository.findByEmailId(email);

		if (optionalUser.isPresent()) {
			return new CustomUserDetail(optionalUser.get());
		} else {
			throw new UsernameNotFoundException("User Not Found");
		}
	}

}
