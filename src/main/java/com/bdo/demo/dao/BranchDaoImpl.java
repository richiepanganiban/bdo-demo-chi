package com.bdo.demo.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.bdo.demo.domain.Branch;

@Repository("branchDao")
public class BranchDaoImpl implements BranchDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public void addBranch(Branch branch) {
		Session session = sessionFactory.getCurrentSession();
		session.save(branch);

	}

	@Override
	public List<Branch> getBranchByName(String branchName) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Branch.class);
		StringBuilder sb = new StringBuilder();
		sb.append("%").append(branchName).append("%");
		criteria.add(Restrictions.like("branchName", sb.toString()));
		return criteria.list();

	}

}
