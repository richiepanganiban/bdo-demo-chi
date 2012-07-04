package com.bdo.demo.domain;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.bdo.demo.auth.UserAuth;

public class Employee {

	@Id
	@OneToOne
	@JoinColumn(name = "USER_ID")
	private UserAuth userAuth;

}
