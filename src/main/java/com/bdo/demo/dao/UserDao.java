package com.bdo.demo.dao;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bdo.demo.auth.UserAuth;

public interface UserDao {

	UserAuth getUser(String username) throws UsernameNotFoundException;

	void addUser(UserAuth user) throws UsernameAlreadyUsedException;

	void changePassword(UserAuth user);

}
