<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Create Account</title>
	<style type="text/css">
		body {
			font-family: Arial, sans-serif;
			background-color: #f1f1f1;
		}
		form {
			background-color: #fff;
			border-radius: 10px;
			box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.3);
			padding: 20px;
			margin: 50px auto;
			width: 300px;
			text-align: center;
		}
		input[type="text"], input[type="password"] {
			display: block;
			margin: 10px auto;
			padding: 10px;
			width: 80%;
			border-radius: 5px;
			border: none;
			background-color: #f9f9f9;
		}
		input[type="submit"] {
			background-color: #4CAF50;
			color: white;
			padding: 10px;
			border: none;
			border-radius: 5px;
			cursor: pointer;
		}
		h2 {
			color: #333;
			margin-bottom: 20px;
		}
		a {
			color:black;
			text-decoration: none;
		}
	</style>
</head>
<body>
	<form action="./createaccount" method="post">
		<h2>Create Account</h2>
		<label for="username">Username:</label>
		<input type="text" id="username" name="username" required>
		<label for="password">Password:</label>
		<input type="password" id="password" name="password" required>
		<input type="submit" value="Create Account">
	</form>
</body>
</html>
    