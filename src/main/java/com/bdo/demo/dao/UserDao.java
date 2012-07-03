package com.bdo.demo.dao;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bdo.demo.auth.UserAuth;

public interface UserDao {
	
	UserAuth findByUsername(String username) throws UsernameNotFoundException;

}
