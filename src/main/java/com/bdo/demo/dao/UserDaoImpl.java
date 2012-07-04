package com.bdo.demo.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.bdo.demo.auth.UserAuth;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public UserAuth getUser(String username) throws UsernameNotFoundException {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM UserAuth where username='" + username + "'");
		List<UserAuth> queryResult = query.list();
		if (queryResult == null || queryResult.isEmpty()) {
			throw new UsernameNotFoundException("User is not found");
		}
		return queryResult.get(0);
	}

	@Override
	public void addUser(UserAuth user) throws UsernameAlreadyUsedException {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserAuth.class);
		criteria.add(Restrictions.eq("username", user.getUsername()));
		if (!criteria.list().isEmpty()) {
			throw new UsernameAlreadyUsedException("Username is already used. Please choose a different one.");
		}
		session.save(user);
	}

	@Override
	public void changePassword(UserAuth user) {

	}

}
