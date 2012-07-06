<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Branch</title>
</head>
<body>
<h1>Branch</h1>
	<c:url var="addBranchUrl" value="/admin/branch/addBranch" />
	<c:url var="searchBranchUrl" value="/admin/branch/searchBranch" />
	<c:url var="editBranchUrl" value="/admin/branch/editBranch" />
	<c:url var="viewAllBranchUrl" value="/admin/branch/viewAllBranches" />
	<c:url var="deleteBranchUrl" value="/admin/branch/deleteBranch" />
	<div>
		<div>
			<a href="${addBranchUrl}">Add Branch</a>
		</div>
		<div>
			<a href="${searchBranchUrl}">Search Branch</a>
		</div>
		<div>
			<a href="${editBranchUrl}">Edit Branch</a>
		</div>
		<div>
			<a href="${viewAllBranchUrl}">View All Branches</a>
		</div>
		<div>
			<a href="${deleteBranchUrl}">Delete Branch</a>
		</div>
	</div>

</body>
</html>