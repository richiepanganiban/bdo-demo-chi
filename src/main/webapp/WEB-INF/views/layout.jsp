<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:getAsString name="title"/></title>
<link href="<spring:url value='/resources/css/reset.css' />" rel="stylesheet" type="text/css" />
<link href="<spring:url value='/resources/css/960_12_col.css' />" rel="stylesheet" type="text/css" />
<link href="<spring:url value='/resources/css/text.css' />" rel="stylesheet" type="text/css" />
<link href="<spring:url value='/resources/css/formalize.css' />" rel="stylesheet" type="text/css" />
<link href="<spring:url value='/resources/css/styles.css' />" rel="stylesheet" type="text/css" />
<!--[if IE]>
  	<link href="<spring:url value='/resources/css/ie.css' />" rel="stylesheet" type="text/css" />
<![endif]-->
<script type="text/javascript" src='<spring:url value="/resources/js/jquery-1.7.2.min.js" />'></script>
<script type="text/javascript" src='<spring:url value="/resources/js/jquery.formalize.min.js" />'></script>
</head>
<body>
	<div class="container_12">
	
		<tiles:insertAttribute name="body" />
		
		<div class="margin_top_large">
			<a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
		</div>
	
	</div>
	
</body>
</html>