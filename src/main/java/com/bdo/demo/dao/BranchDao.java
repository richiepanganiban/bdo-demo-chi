package com.bdo.demo.dao;

import com.bdo.demo.domain.Branch;

public interface BranchDao {

	void addBranch(Branch branch);

	Branch getBranchByName(String branchName);

}
