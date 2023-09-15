<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <jsp:include page="navigationpage.jsp"/>
    <%
     String msg = (String) request.getAttribute("msg");
    %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Machine</title>
<style>
form {
  height: 500px;
  width: 400px;
  display: table;
  margin: 0 auto;
}

form table {
  width: 100%;
  height: 100%;
}

.td{
  padding: 10px;
  border: 1px solid black;
  font-family: fantasy;
}


  input[type="submit"] {
    background-color: #4CAF50;
    color: white;
    padding: 8px 16px;
    border: none;
    border-radius: 4px;
    position: relative;
    left: 330px;
    top: 30px;
     position: relative;
    left: 180px;
    font-size: 20px;
  }

#message{

color:blue;
position: relative;
left: 120px;
}

#main{
   height:100vh;
  background-image: url("https://media.istockphoto.com/id/1264255911/photo/blueprints-and-3d-metal-machine-parts-mechanical-engineering-concept.jpg?s=1024x1024&w=is&k=20&c=Lc5qsFwV9boXO0kXNPPdZddy-zw1gPX3P0CMzeeZBHU=");
  background-repeat: no-repeat;
  background-size: cover;
  }
  
  table{
   background-color:white;
  }
</style>


</head>

<body>
<div id="main">
<form action="./add" method="post" >
       <h4 align="center">ADD THE MACHINE DETALS</h4>
	<table>
		<tr>
			<td class="td"><label>Machine Name:</label></td>
			<td class="td"><input type="text" id="Machine_Name" name="Machine_Name" required></td>
		</tr>
		<tr>
			<td class="td"><label >Working Principle:</label></td>
			<td class="td"><input type="text" id="Working_Principle" name="Working_Principle" required></td>
		</tr>
		<tr>
			<td class="td"><label>Tools:</label></td>
			<td class="td"><input type="text" id="Tools" name="Tools" required></td>
		</tr>
		<tr>
			<td id="submit"><input type="submit" value="Submit"></td>
		</tr>
	</table>
     
    
    	<div id="message"> <%
			if (msg != null) {
			%>
			<h3><%=msg%></h3>
			<%
			}
			%>
		</div>	
    
</form>

</div>



</body>
</html>