package com.bdo.demo.auth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Long id;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	// @OneToOne
	// @JoinColumn(name = "")

}
