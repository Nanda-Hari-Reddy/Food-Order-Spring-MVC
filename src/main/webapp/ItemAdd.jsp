<%@page import="com.jsp.foodapp.dto.Item"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		Item item = (Item)request.getAttribute("Item");
	%>
		<form:form action="ItemAdded" modelAttribute="Item">
			Item Name:        <form:input readonly="true" value="<%= item.getName() %>" path="name"/><br>
			Item Cost:        <form:input readonly="true" value="<%= item.getCost() %>" path="cost"/><br>
			Enter Quantity:        <form:input path="quantity"/>
			<input type="submit">
		</form:form>
</body>
</html>