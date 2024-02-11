package com.java.service;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.java.repository.UserRepository;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class UserServiceTest {

	@Mock
	private UserRepository userRepository;

	private UserService userService;


	@BeforeEach
	void setUp() {
		this.userService = new UserService();
		this.userService.setUserRepository(userRepository);
	}

	@Test
	void getAllUsersTest() {

		userService.getAllUsers();
		verify(userRepository).findAll();

	}

}
