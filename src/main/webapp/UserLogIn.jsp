<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="UserValidate" method="post">
		enter email:<input type="email" name="email">
		Enter password:<input type="password" name="password">
		<input type="submit">
	</form>
<h2>${msg}</h2></body>
</html> 