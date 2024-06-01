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
${msg}
	<table align="center" cellpadding="20px" border="2">
		<tr>
			<th>Product Id</th>
			<th>Product Name</th>
			<th>Type</th>
			<th>Cost</th>
			<th>Cart</th>
		</tr>
		<c:forEach var="p" items="${ProductList}">
		<tr>
			<td>${p.getId()}</td>	
			<td>${p.getName()}</td>	
			<td>${p.getType()}</td>	
			<td>${p.getCost()}</td>
			<td><a href="AddItem?id=${p.getId()}">Add</a></td>		
		</tr>
		</c:forEach>
		<tr>
			<td colspan="2" cellpadding="0px" align="center"><a href="UserHome"><button>Back</button></a></td>
			<td colspan="3" cellpadding="0px" align="center"><a href="submitOrder"><button>Order</button></a></td>
		</tr>
		
	</table>
</body>
</html>