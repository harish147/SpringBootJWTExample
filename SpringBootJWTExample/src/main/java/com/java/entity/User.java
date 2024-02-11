package com.java.entity;

import jakarta.persistence.Column;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity(name = "_user")
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String firstName;

	private String middleName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false, unique = true)
	private String mobileNumber;

	@Column(nullable = false, unique = true)
	private String emailId;

	private String address;

	private String city;

	private String state;

	private String contry;

	@ManyToMany(fetch = FetchType.EAGER)
	private Set<UserRole> roles;

	@Column(nullable = false)
	private String password;

}
