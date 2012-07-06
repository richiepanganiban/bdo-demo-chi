<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search Branch</title>
</head>
<body>
<h1>Search Branch</h1>

<form action="<c:url value="/admin/branch/searchBranch"/>" method="GET">
	<input type="text" name="branchName"/>
	<input type="submit" value="Search"/>
</form>

<c:if test="${not empty branchesAttribute}" >

	<div class="float_left">
		<div class="margin_right_medium">
			<h6>Branch Name</h6>
		</div>
	</div>
	<div>
		<h6>Branch Location</h6>
	</div>
	<div class="clear_left"></div>
	<c:forEach var="branch" items="${branchesAttribute }">
		<form:form modelAttribute="branch">
			<div class="float_left">
				<div>
					<form:input path="name" disabled="disabled"/>
				</div>
				<div>
					<form:input path="location" disabled="disabled"/>
				</div>
			</div>
		</form:form>
		<div class="clear_left"></div>
	</c:forEach>
</c:if>


</body>
</html>