package com.bdo.demo.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bdo.demo.auth.Role;

@Repository("roleDao")
public class RoleDaoImpl implements RoleDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public List<Role> getAllRoles() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Role.class);
		return criteria.list();
	}

}
