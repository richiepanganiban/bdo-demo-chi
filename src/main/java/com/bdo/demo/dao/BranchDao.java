package com.bdo.demo.dao;

import java.util.List;

import com.bdo.demo.domain.Branch;

public interface BranchDao {

	void addBranch(Branch branch);

	List<Branch> getBranchByName(String branchName);

}
