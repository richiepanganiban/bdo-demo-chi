package com.bdo.demo.service;

import static org.mockito.Mockito.verify;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.bdo.demo.dao.BranchDao;
import com.bdo.demo.domain.Branch;

@RunWith(MockitoJUnitRunner.class)
public class AdminServiceTest {

	@InjectMocks
	private AdminServiceImpl adminService = new AdminServiceImpl();

	@Mock
	private BranchDao branchDao;

	@Test
	public void shouldAddBranch() {
		// given
		Branch branch = new Branch();
		branch.setBranchName("Ayala Branch");
		branch.setLocation("Ayala Avenue, Makati");
		adminService.addBranch(branch);

		// when
		verify(branchDao).addBranch(branch);
	}

	@After
	public void tearDown() {
		adminService = null;
		branchDao = null;
	}

}
