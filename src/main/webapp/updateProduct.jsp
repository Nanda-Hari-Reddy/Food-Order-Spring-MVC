<%@page import="com.jsp.foodapp.dto.Products"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	Products prod = (Products)request.getAttribute("Product");

	%>
	<form:form action="UpdateData" modelAttribute="Product">
		Enter new Product Id   :      <form:input value="<%= prod.getId() %>" readonly="true" path="id"/>
		Enter new Product Name :      <form:input value="<%= prod.getName() %>" path="name"/>
		Enter new Product Type :      <form:input value="<%= prod.getType() %>" path="type"/>
		Enter new Product Cost :      <form:input value="<%= prod.getCost() %>" path="cost"/>
		<button type="submit" >save</button>
	</form:form>
</body>
</html>