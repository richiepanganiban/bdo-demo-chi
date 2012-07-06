<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Page</title>
</head>
<body>
	<h1>Admin Page</h1>
	<c:url var="branchUrl" value="/admin/branch" />
	<c:url var="employeeUrl" value="/admin/employee" />
	<div>
		<div>
			<a href="${branchUrl}">Branch</a>
		</div>
		<div>
			<a href="${employeeUrl}">Employee</a>
		</div>
	</div>


</body>
</html>

<script type="text/javascript">
	$(function() {

	});
</script>