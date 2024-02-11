package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.dto.request.AuthenticationDto;
import com.java.util.JwtAuthenticationUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtAuthenticationUtil authenticationUtil;
	
	@PostMapping("/generatetoken")
	public String authenticateAndGenerateToken(@RequestBody AuthenticationDto authenticationDto) {
		
		
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(authenticationDto.getUsername(), authenticationDto.getPassword());
		Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		
		if(authentication.isAuthenticated()) {
			return authenticationUtil.generateToken(authenticationDto.getUsername());
		}
		else {
			throw new UsernameNotFoundException("Invalid User credentials");
		}
				
	}
	
}
