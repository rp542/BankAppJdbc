<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body bgcolor="pink" style="text-align: left">
<%@include file="header.jsp" %>
	<br>
	<br>

	<h1>Customer Information</h1>
	<br>
	<h4>Customer Id: ${customer.customerId}</h4>
	<h4>Customer Name: ${customer.customerName}</h4>
	<h4>Customer Password: ${customer.password}</h4>
	<h4>Customer Address: ${customer.address}</h4>
	<h4>Customer Date of Birth: ${customer.dateOfBirth}</h4>
	<%-- <h4>Customer Account Id: ${customer.customerAccount.accountId}</h4> --%>
	<a href="edit.jsp"> Edit Profile</a>
</body>
</html>