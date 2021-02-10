<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>login screen</title>
<link rel="stylesheet" href="login.css">
</head>
<body>
	<div class="container">
		<center><h1 style="font-family: cursive;">Limra Public School<br>Faculty Login</h1></center>
		
		<form class="form" action="facultyloginurl" method="post">
			<input type="text" placeholder="username" name="user"> 
			<input type="password" placeholder="password" name="pwd">
			<button type="submit" id="login_button">login</button>
		</form>
	</div>
	<a href="home.jsp">home</a>
</body>
</html>
