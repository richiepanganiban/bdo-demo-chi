package com.bdo.demo.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bdo.demo.dao.BranchDao;
import com.bdo.demo.domain.Branch;

@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {

	@Resource(name = "branchDao")
	private BranchDao branchDao;

	@Override
	public void addBranch(Branch branch) {
		branchDao.addBranch(branch);
	}

}
