package com.bdo.demo.service;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bdo.demo.auth.UserAuth;
import com.bdo.demo.dao.UserDao;

@Service("userDetailsService")
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	@Resource(name = "userDao")
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserAuth storedUser = userDao.getUser(username);
		Collection<GrantedAuthority> rolesForUser = new ArrayList<GrantedAuthority>();
		rolesForUser.add(new SimpleGrantedAuthority(storedUser.getRole().getRoleName()));
		User user = new User(storedUser.getUsername(), storedUser.getPassword(), rolesForUser);
		return user;
	}

}
