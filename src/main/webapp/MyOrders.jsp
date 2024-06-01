<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<c:forEach var="Order" items="${OdderList}">
					
			<table align="center" cellpadding="20px" border="2">
				<tr>
					<td border="0">Name:</td>	
					<td>${Order.getName()}</td>	
				</tr>
				<tr border="0">
					<td>Mobile:</td>	
					<td>${Order.getName()}</td>	
				</tr>
				<tr border="0">
					<td>Total Bill:</td>	
					<td>${Order.getTotalCost()}</td>	
				</tr>
				
				<tr>
					<th>Name</th>
					<th>Quantity</th>
					<th>Cost</th>
				</tr>
				<c:forEach var="Item" items="${Order.getItem()}">
				<tr>
					<td>${Item.getName()}</td>	
					<td>${Item.getQuantity()}</td>	
					<td>${Item.getCost()}</td>
				</tr>
				</c:forEach>
			</table>
			<br>
			<br>
			<br>
		</c:forEach>
		
</body>
</html>