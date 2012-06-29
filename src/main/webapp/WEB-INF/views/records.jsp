<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Records</h1>
 

<table style="border: 1px solid; width: 100%; text-align:center">
 <thead style="background:#d3dce3">
  <tr>
   <th>Id</th>
   <th>First Name</th>
   <th>Last Name</th>
   <th>Money</th>
   <th colspan="2"></th>
   <th>CC Type</th>
   <th>CC Number</th>
   <th colspan="3"></th>
  </tr>
 </thead>
 <tbody style="background:#ccc">
 <c:forEach items="${persons}" var="person">
  <c:url var="editUrl" value="/main/record/edit?id=${person.id}" />
  <c:url var="deleteUrl" value="/main/record/delete?id=${person.id}" />
   
  <c:if test="${!empty person.creditCards}">
   <c:forEach items="${person.creditCards}" var="creditCard">
   <tr>
    <td><c:out value="${person.id}" /></td>
    <td><c:out value="${person.firstName}" /></td>
    <td><c:out value="${person.lastName}" /></td>
    <td><c:out value="${person.money}" /></td>
    <td><a href="${editUrl}">Edit</a></td>
    <td><a href="${deleteUrl}">Delete</a></td>
     
    <td><c:out value="${creditCard.type}" /></td>
    <td><c:out value="${creditCard.number}" /></td>
    <c:url var="addCcUrl" value="/main/creditcard/add?id=${person.id}" />
    <c:url var="editCcUrl" value="/main/creditcard/edit?id=${creditCard.id}" />
    <c:url var="deleteCcUrl" value="/main/creditcard/delete?id=${creditCard.id}" />
    <td><a href="${addCcUrl}">+</a></td>
    <td><a href="${editCcUrl}">Edit</a></td>
    <td><a href="${deleteCcUrl}">Delete</a></td>
   </tr>
   </c:forEach>
  </c:if>
   
  <c:if test="${empty person.creditCards}">
   <tr>
    <td><c:out value="${person.id}" /></td>
    <td><c:out value="${person.firstName}" /></td>
    <td><c:out value="${person.lastName}" /></td>
    <td><c:out value="${person.money}" /></td>
    <td><a href="${editUrl}">Edit</a></td>
    <td><a href="${deleteUrl}">Delete</a></td>
     
    <td>N/A</td>
    <td>N/A</td>
    <c:url var="addCcUrl" value="/main/creditcard/add?id=${person.id}" />
    <td><a href="${addCcUrl}">+</a></td>
    <td></td>
    <td></td>
   </tr>
  </c:if>
   
 </c:forEach>
 </tbody>
</table>
 
<c:if test="${empty persons}">
 No records found. 
</c:if>
 
<p><a href="${addUrl}">Create new record</a></p>
 
</body>
</html>