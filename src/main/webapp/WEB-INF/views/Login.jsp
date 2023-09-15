<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

  <% String message=(String) request.getAttribute("msg");%>
<!DOCTYPE html>
<html>
<head>
	<title>Login page</title>
	<style type="text/css">
		body {
			font-family: Arial, sans-serif;
			
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
			color: back;
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
			color: #4CAF50;
			text-decoration: none;
		}
		
		#message{
		 color: blue;
		
		}
	</style>
</head>
<body>
	<form action="./login" method="post" align="center">
		<h2>Login</h2>
		<label for="username">Username:</label>
		<input type="text" id="username" name="username">
		<label for="password">Password:</label>
		<input type="password" id="password" name="password">
		<input type="submit" value="Login">
		<p>Don't have an account? <a href="./createaccount">Create account..</a></p>
	</form>
	
	<div id="message" align="center">
	   <%if(message !=null) {%>
	  <h3> <%=message %></h3> 
	   <%} %>
	 </div>
</body>
</html>

</html>
    