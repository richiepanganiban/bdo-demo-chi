package com.bdo.demo.dao;

import static org.springframework.util.Assert.notEmpty;

import java.util.List;

import javax.annotation.Resource;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.junit.Test;

import com.bdo.demo.auth.Role;

public class RoleDaoTest extends BaseDaoTest {

	@Resource(name = "roleDao")
	private RoleDaoImpl roleDao;

	@Test
	public void shouldReturnAllRoles() {
		// when
		List<Role> roles = roleDao.getAllRoles();

		// then
		notEmpty(roles);
		assertTrue(roles.size() == 3);
		Role role = roles.get(0);
		assertEquals(role.getRoleName(), "ROLE_ADMIN");
		assertEquals(role.getId(), new Long(1));
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		return new FlatXmlDataSet(this.getClass().getResourceAsStream("/dataset.xml"));
	}

}
