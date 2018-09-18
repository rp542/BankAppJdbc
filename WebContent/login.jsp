<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="header.jsp" %>
</head>
<body style="text-align:left">
<br>
	<h1>Login</h1>
	<form action="login" method="post">
	
		<label>Customer Id: </label>
		<input type="text" size="15" name = "customerId" required>
		<br>
		
		<label>Password: </label>
		<input type="password" size="15" name = "password" required>
		<br>
	
	
			<input type="submit" value="Log In">
		
	
	</form>
</body>
</html>