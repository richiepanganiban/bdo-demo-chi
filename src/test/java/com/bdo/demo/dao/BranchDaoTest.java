package com.bdo.demo.dao;

import javax.annotation.Resource;

import org.junit.Test;

import com.bdo.demo.domain.Branch;

public class BranchDaoTest extends BaseDaoTest {

	@Resource(name = "branchDao")
	private BranchDaoImpl branchDao = new BranchDaoImpl();

	@Test
	public void shouldAddBranch() {
		// given
		Branch branch = new Branch();
		branch.setBranchName("Ayala Branch");
		branch.setLocation("Ayala Avenue, Makati");

		// when
		branchDao.addBranch(branch);

		// then
		Branch branchFromDb = branchDao.getBranchByName("Ayala Branch");
		assertEquals("Ayala Branch", branchFromDb.getBranchName());

	}

}
