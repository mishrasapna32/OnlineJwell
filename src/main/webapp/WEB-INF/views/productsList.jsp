<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<%@include file="header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get all products</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


</head>
<body>
<h1>list of products</h1>
<table class="table table-bordered">

<tr>
 <th>IMAGE</th>
<th>ID</th>
<th>NAME</th>
<th>CATEGORY NAME</th>
<th>PRICE</th>
<th>Delete/Edit/View</th>
</tr>

<c:forEach items="${products}" var="b">
<tr>
 <c:url value="resources/images/${b.id}.jpg" var="src" />
<td ><img src="${src }"/></td>
<td><a href="getProductById/${b.id}">${b.id}</a></td>
<td>${b.name}</td>
<td>${b.category.categoryName }</td>
<td>${b.price}</td>
<td>
   <security:authorize ifAnyGranted="ROLE_ADMIN">
   <a href="deleteProduct/${b.id }"><span class="glyphicon glyphicon-trash"></span></a>
	&nbsp &nbsp  &nbsp &nbsp 
   <a href="editProduct/${b.id }"><span class="glyphicon glyphicon-edit"></span></a>
  	&nbsp &nbsp  &nbsp &nbsp 
  	</security:authorize>
  	
  	
  <a href="getProductById/${b.id}"><span class="glyphicon glyphicon-info-sign"></span></a>
  </td>
</tr>
</c:forEach>

</table>
<%@include file="footer.jsp" %>
</body>
</html>