package com.bdo.demo.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bdo.demo.auth.UserAuth;

@Entity
@Table(name = "BRANCHES")
public class Branch {

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Long id;

	@Column(name = "BRANCH_NAME")
	private String branchName;

	@Column(name = "LOCATION")
	private String location;

	@OneToMany
	@JoinTable(name = "BRANCH_USERS",
			joinColumns = @JoinColumn(name = "BRANCH_ID"),
			inverseJoinColumns = @JoinColumn(name = "USER_ID"))
	private List<Employee> users;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<UserAuth> getUsers() {
		return users;
	}

	public void setUsers(List<UserAuth> users) {
		this.users = users;
	}

}
