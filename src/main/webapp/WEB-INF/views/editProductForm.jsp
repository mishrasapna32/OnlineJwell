<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@include file="header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:url value="/editProduct" var="url"></c:url> 
	<form:form method="post" action="${url}" commandName="editProductObj">
		<table>
		
		<tr>
			<td><form:label path="id">ID</form:label></td>
			<td><form:input path="id" disabled="true"/>
			<form:hidden path="id"/></td>
        </tr>
        <tr>
        <td><form:label path="name">NAME</form:label>  </td>
        <td><form:input path="name"></form:input></td>
	    </tr>
	     <tr>
        <td><form:label path="dealer">DEALER</form:label>  </td>
        <td><form:input path="dealer"></form:input></td>
	    </tr>
	     <tr>
        <td><form:label path="price">PRICE</form:label>  </td>
        <td><form:input path="price"></form:input></td>
	    </tr>
	   
	    <tr>
	    <td><form:label path="category">CATEGORY</form:label></td>
	    <td>
	    <form:radiobutton path="category.cid" value="1"/>ring
	     <form:radiobutton path="category.cid" value="2"/>necklase
	      <form:radiobutton path="category.cid" value="3"/>earings
	       <form:radiobutton path="category.cid" value="4"/>bangles
	    </td>
	    </tr>
	    <tr>
	    <td colspan="2"><input type="submit" value="EditProduct"></td>
	    </tr>
		</table>
	</form:form>
<%@include file="footer.jsp" %>

</body>
</html>
