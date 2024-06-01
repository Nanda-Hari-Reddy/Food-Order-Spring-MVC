<%@page import="com.jsp.foodapp.dto.FoodOrder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		FoodOrder fOrder = (FoodOrder)session.getAttribute("foodorder");
	%>
	<table align="center" cellpadding="20px" border="2">
		<tr>
			<th>Name</th>
			<th>Quantity</th>
			<th>Cost</th>
		</tr>
			<c:forEach var="items" items="${ItemList}">
			
		<tr>
			<td>${items.getName()}</td>	
			<td>${items.getQuantity()}</td>	
			<td>${items.getCost()}</td>		
		</tr>
			</c:forEach>
		<tr>
			<td colspan="2" cellpadding="0px" align="center">Total Cost</td>
			<td><% fOrder.getTotalCost(); %></td>
		</tr>
	</table>
</body>
</html>