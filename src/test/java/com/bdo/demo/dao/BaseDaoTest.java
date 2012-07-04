package com.bdo.demo.dao;

import javax.annotation.Resource;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext-dao-test.xml" })
@Transactional
public abstract class BaseDaoTest extends DBTestCase {

	static {
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "org.hsqldb.jdbcDriver");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:hsqldb:mem:mock_database");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "mock_username");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "mock_password");
	}

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	private Session session;

	@Override
	@Before
	public void setUp() throws Exception {
		HSQLServerUtil.getInstance().start("mock_database");
		session = sessionFactory.openSession();
		super.setUp();
	}

	@Override
	@After
	public void tearDown() throws Exception {
		session.close();
		super.tearDown();
		HSQLServerUtil.getInstance().stop();
	}

}
