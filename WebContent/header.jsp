<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<!DOCTYPE html>
<html>
<head>
<style>
body {
	background-color: pink;
}

.container {
	position: relative;
}

.topleft {
	height: 100%;
	background-color: blue;
	position: absolute;
	top: 2px;
	right: 6px;
	font-size: 18px;
}

header h3 {
	display: inline;
	margin-right: 1em;
}

img {
	width: 20%;
	height: auto;
	opacity: 0.9;
}

.topright {
	position: absolute;
	top: 100px;
	right: 16px;
	font-size: 18px;
}

#ABC {
	background-color: red;
	height: 5%;
	position: absolute;
	top: 5;
	left: 0;
	right: 0;
	width: 100%;
}
</style>
</head>
<body>
	
	<div class="container">

		<div class="topright"></div>
	</div>
	<br>
	<h1>Welcome to ABC BANK</h1>
	<br>
	<header>
		<section id="pqr">

			<h3>
				<a href="header.jsp">Home</a>
			</h3>
			<h3>
				<a href="edit.jsp">Update Profile</a>
			</h3>
			<h3>
				<a href="transfer.jsp">Transfer Money</a>
			</h3>
			<h3>
				<a href="checkBalance.jsp">Check Balance</a>
			</h3>
			<h3>
				<a href="changePassword.jsp">Change Password</a>
			</h3>
			<h3>
				<a href="displayProfile.jsp">Profile</a>
			</h3>
			<h3>
				<a href="logout.jsp">Logout</a>
			</h3>
			<h3>
				<a href="login.jsp">Login</a>
			</h3>
		</section>



	</header>
</body>
</html>