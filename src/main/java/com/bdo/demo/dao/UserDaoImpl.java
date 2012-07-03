package com.bdo.demo.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.bdo.demo.auth.UserAuth;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public UserAuth findByUsername(String username) throws UsernameNotFoundException {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM users where username=" + username);
		List<UserAuth> queryResult = query.list();
		if(queryResult == null || queryResult.isEmpty()) {
			throw new UsernameNotFoundException("User is not found");
		}
		return queryResult.get(0);
	}

}
