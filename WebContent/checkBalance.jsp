<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="header.jsp" %>
<title>AccountBalance</title>
</head>
<body bgcolor="pink" style="text-align:left">
<br><br><br><br><br>
<h1>Your balance is:  ${sessionScope.customer.bankAccount.balance}</h1>		
</body>
