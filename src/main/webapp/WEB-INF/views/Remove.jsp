<%@page import="com.jspiders.StudentRegistration.pojo.MachinePOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="navigationpage.jsp"/>

<%
List<MachinePOJO> pojos = (List<MachinePOJO>)request.getAttribute("POJOS");
String message=(String)request.getAttribute("remove");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Machine List</title>
    <style>
        fieldset {
            border: 1px solid #ccc;
            margin-bottom: 20px;
            padding: 10px;
        }
        legend {
            font-weight: bold;
        }
        form {
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input[type=text] {
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 3px;
            width: 200px;
        }
        table {
            border-collapse: collapse;
            margin: 0 auto;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 5px;
            text-align: center;
        }
        th {
            background-color: #eee;
            font-weight: bold;
        }
        
        #message{
        position:relative;
        left:630px;
        color:red;
        }
        
        body{
         background-image: url("https://thumbs.dreamstime.com/z/mechanical-background-470100.jpg");
        }
    </style>
</head>
<body>

   <div id="message"> <%
			if (message!= null) {
			%>
			<h3><%=message%></h3>
			<%
			}
			%>
		</div>	
       
    <fieldset>
        <legend>Machine List</legend>
        <form action="./remove" method="post">
            <label for="id">Enter the ID no of the machine you want to Remove</label>
            <input type="text" name="id" id="id" required>
            <input type="submit" value="SUBMIT">
        </form>
    </fieldset>
    
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Machine Name</th>
                <th>TOOLS</th>
                 <th>WORKING PRINCIPLE</th>
                
            </tr>
        </thead>
        <tbody>
            <% for (MachinePOJO machine : pojos) { %>
            <tr>
                <td><%= machine.getId() %></td>
                <td><%= machine.getMachine_Name() %></td>
                <td><%= machine.getTools() %></td>
                <td><%= machine.getWorking_Principle()%></td>
            </tr>
            <% } %>
        </tbody>
    </table>
        	
    
</body>
</html>
