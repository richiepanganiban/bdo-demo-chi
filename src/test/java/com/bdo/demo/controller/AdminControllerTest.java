package com.bdo.demo.controller;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.mockito.Mockito.verify;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.ExtendedModelMap;

import com.bdo.demo.domain.Branch;
import com.bdo.demo.service.AdminService;

@RunWith(MockitoJUnitRunner.class)
public class AdminControllerTest {

	@InjectMocks
	private AdminController adminController = new AdminController();

	@Mock
	private AdminService adminService;

	@Test
	public void shouldReturnAdminPage() {
		// when
		String adminPage = adminController.getAdminPage();

		// then
		assertEquals("admin", adminPage);
	}

	@Test
	public void shouldReturnBaseBranchPage() {
		// when
		String branchPage = adminController.getBranchPage();

		// then
		assertEquals("branch", branchPage);

	}

	@Test
	public void shouldReturnAddBranchPage() {
		// given
		ExtendedModelMap model = new ExtendedModelMap();

		// when
		String addBranchPage = adminController.getAddBranchPage(model);

		// then
		Branch branch = (Branch) model.get("branchAttribute");
		assertNotNull(branch);
		assertEquals("addBranch", addBranchPage);
	}

	@Test
	public void shouldAddNewBranch() {
		// given
		Branch branch = new Branch();
		branch.setBranchName("Ayala Branch");
		branch.setLocation("Ayala Avenue, Makati");

		// when
		String addBranchRedirect = adminController.postAddBranch(branch);

		// then
		assertEquals("redirect:/admin/branch", addBranchRedirect);
		verify(adminService).addBranch(branch);

	}

	@After
	public void tearDown() {
		adminController = null;
		adminService = null;
	}
}
