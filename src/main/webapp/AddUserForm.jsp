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

	<form:form action="SaveUser" modelAttribute="User">
	 	Enter Name: <form:input path="name"/>
		Enter Email: <form:input path="email"/>
		Enter PassWord: <form:input path="password"/>
		<input type="submit">
	</form:form>
</body>
</html>