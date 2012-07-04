package com.bdo.demo.util;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateUtil {

	private HibernateUtil() {
		// Util class. No Implementation.
	}

	@Resource(name = "sessionFactory")
	private static SessionFactory sessionFactory;

	public static Session getHibernateSession() {
		return sessionFactory.getCurrentSession();
	}

}
