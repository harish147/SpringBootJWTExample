package com.java.dto.request;

import java.util.List;

import lombok.Data;

@Data
public class UserRequestDto {

	private String firstName;

	private String middleName;

	private String lastName;

	private String mobileNumber;

	private String emailId;

	private String address;

	private String city;

	private String state;

	private String contry;

	private List<String> roles;

	private String password;
}
