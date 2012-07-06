package com.bdo.demo.dao;

import java.util.List;

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
		List<Branch> queriedBranchFromDb = branchDao.getBranchByName("Ayala Branch");
		assertEquals("Ayala Branch", queriedBranchFromDb.get(0).getBranchName());
	}

}
