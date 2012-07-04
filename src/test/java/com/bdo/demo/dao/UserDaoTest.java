package com.bdo.demo.dao;

import javax.annotation.Resource;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.junit.Test;

import com.bdo.demo.auth.Role;
import com.bdo.demo.auth.UserAuth;

public class UserDaoTest extends BaseDaoTest {

	@Resource(name = "userDao")
	private UserDaoImpl userDao;

	@Test
	public void shouldReturnSpecificUser() {
		// when
		UserAuth user = userDao.getUser("chi");

		// then
		assertEquals(user.getPassword(), "chi_password");
		assertEquals(user.getRole().getRoleName(), "ROLE_ADMIN");
	}

	@Test
	public void shouldAddAUserWithRole() throws UsernameAlreadyUsedException {
		// given
		Role role = new Role();
		role.setId(new Long(1));
		role.setRoleName("ROLE_ADMIN");
		UserAuth user = new UserAuth();
		user.setUsername("peter_parker");
		user.setPassword("iamspiderman");
		user.setRole(role);

		// when
		userDao.addUser(user);

		// then
		UserAuth userFromDb = userDao.getUser("peter_parker");
		Role roleFromDb = userFromDb.getRole();
		assertEquals(userFromDb.getUsername(), "peter_parker");
		assertEquals(userFromDb.getPassword(), "iamspiderman");
		assertEquals(roleFromDb.getId(), new Long(1));
		assertEquals(roleFromDb.getRoleName(), "ROLE_ADMIN");

	}

	@Test(expected = UsernameAlreadyUsedException.class)
	public void shouldThrowUsernameNotAvailableException() throws UsernameAlreadyUsedException {
		// given
		Role role = new Role();
		role.setId(new Long(1));
		UserAuth user = new UserAuth();
		user.setUsername("chi");
		user.setPassword("chi_password");
		user.setRole(role);

		// when
		userDao.addUser(user);
	}

	@Test
	public void shouldChangePasswordOfUser() {
		// given
		UserAuth userFromDb = userDao.getUser("chi");
		userFromDb.setPassword("chi_updatedpassword");

		// when
		userDao.changePassword(userFromDb);

		// then
		UserAuth updatedUser = userDao.getUser("chi");
		System.out.println(updatedUser.getPassword());
		assertEquals(updatedUser.getPassword(), "chi_updatedpassword");

	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		return new FlatXmlDataSet(this.getClass().getResourceAsStream("/dataset.xml"));
	}

}
