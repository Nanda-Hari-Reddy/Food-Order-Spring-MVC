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
	<table align="center" cellpadding="20px" border="2">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Type</th>
			<th>Cost</th>
			<th>Modify</th>
			<th>Remove</th>
		</tr>
			<c:forEach var="product" items="${prodList}">
			
		<tr>
			<td>${product.getId()}</td>	
			<td>${product.getName()}</td>	
			<td>${product.getType()}</td>
			<td>${product.getCost()}</td>	
			<td><a href="Update?id=${product.getId()}">Update</a></td>
			<td><a href="Delete?id=${product.getId()}">Delete</a></td>			
		</tr>
			</c:forEach>
		<tr>
			<td colspan="6" cellpadding="0px" align="center"><a href="AddProduct"><button>Add Product</button></a></td>
		</tr>
	</table>
</body>
</html>