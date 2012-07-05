package com.bdo.demo.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bdo.demo.domain.Branch;
import com.bdo.demo.service.AdminService;

@Controller("adminController")
@RequestMapping("/admin")
public class AdminController {

	@Resource(name = "adminService")
	private AdminService adminService;

	@RequestMapping
	public String getAdminPage() {
		return "admin";
	}

	@RequestMapping(value = "/branch", method = RequestMethod.GET)
	public String getBranchPage() {
		return "branch";
	}

	@RequestMapping(value = "/branch/addBranch", method = RequestMethod.GET)
	public String getAddBranchPage(Model model) {
		Branch branch = new Branch();
		model.addAttribute("branchAttribute", branch);
		return "addBranch";
	}

	@RequestMapping(value = "/branch/addBranch", method = RequestMethod.POST)
	public String postAddBranch(@ModelAttribute("branchAttribute") Branch branch) {
		adminService.addBranch(branch);
		return "redirect:/admin/branch";
	}

}
