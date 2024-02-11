package com.java.repository;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.java.entity.User;
import com.java.entity.UserRole;

@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserRoleRepository userRoleRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Test
	void findByEmailIdTest() {
		
		UserRole userRole = new UserRole();
		userRole.setRole("ROLE_ADMIN");
		UserRole savedUserRole = userRoleRepository.save(userRole);
		
		
		User user = new User();
		user.setFirstName("TestFirstName");
		user.setLastName("TestLastName");
		user.setMobileNumber("0000000001");
		user.setEmailId("user@test.com");
		user.setAddress("TestAddress");
		user.setCity("TestCity");
		user.setState("TestState");
		user.setContry("TestContry");
		user.setPassword(bCryptPasswordEncoder.encode("Test"));
		user.setRoles(Set.of(savedUserRole));
		userRepository.save(user);

		Optional<User> optionalUser = userRepository.findByEmailId("user@test.com");

		Boolean actualOutput = optionalUser.isPresent();

		assertThat(actualOutput).isTrue();

	}

	@AfterEach
	public void deleteTestUser() {
		userRepository.delete(userRepository.findByEmailId("user@test.com").get());
	}
}
