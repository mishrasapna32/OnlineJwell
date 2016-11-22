<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isELIgnored="false"%>
<%@include file="header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OnlineJwell</title>     
</head>
<body>
<h1>PRODUCT BY ID</h1>
ID:${productObj.id}<br>
NAME:${productObj.name}<br>
PRICE:${productObj.price}<br>
<%@include file="footer.jsp" %>
</body>
</html>