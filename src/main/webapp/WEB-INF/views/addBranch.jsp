<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Branch</title>
</head>
<body>
<h1>Add Branch</h1>
<div>
<spring:url var="addBranchUrl" value="/admin/addBranch" />
<form:form modelAttribute="branchAttribute" action="${addBranchUrl}" method="POST">
	<div>
		<form:label path="branchName">Branch Name: </form:label>
		<form:input path="branchName"/>
	</div>
	<div>
		<form:label path="location">Location: </form:label>
		<form:input path="location"/>
	</div>
	<input type="submit" value="Add Branch"/>
	<input type="reset" value="Reset"/>
</form:form>
</div>

</body>
</html>