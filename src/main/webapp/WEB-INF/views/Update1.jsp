<%@page import="com.jspiders.StudentRegistration.pojo.MachinePOJO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="navigationpage.jsp"/>
  <%MachinePOJO pojo=(MachinePOJO) request.getAttribute("pojo");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

<style>

  /* Center the table */
  .center {
    display: flex;
    justify-content: center;
  }

  /* Style the table */
  table {
    border-collapse: collapse;
    width: 100%;
    max-width: 800px;
    margin: 0 auto;
  }

  /* Style the table headers */
  th {
    background-color: #eee;
    font-weight: bold;
    text-align: left;
    padding: 10px;
  }

  /* Style the table cells */
  .td{
    border: 1px solid #ddd;
    padding: 10px;
  }

  /* Style the form inputs */
  input[type="text"] {
    width: 100%;
    padding: 8px 16px;
    margin: 8px 0;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
  }

  /* Style the submit button */
  input[type="submit"] {
    background-color: #4CAF50;
    color: white;
    padding: 8px 16px;
    border: none;
    border-radius: 4px;
    position: relative;
    left: 330px;
    top: 30px;
  }
  
  #button2{
  position: relative;
  bottom: 38px;  
  right: 360px; 
   }

  #image{
   height: 70vh;
   width:60vw;
   position:relative;
   left: 270px;
  
  }
</style>

</head>
<body>
  <%if( pojo !=null){ %>
  <form action="./updatemachine" method="post">
  <table id="table" >
   <thead>
      <tr>
        <th>ID</th>
        <th>MACHINE NAME</th>
        <th>MACHINE TOOL</th>
        <th>MACHINE DESCRIPTION</th>
      </tr>
   </thead>
   <tbody>
	<tr>
	 <td class="td"><input type="text" name="id" value=<%=pojo.getId() %> readonly></td>
	 <td class="td"><input type="text" name="Machine_Name" value=<%=pojo.getMachine_Name() %>></td>
	 <td class="td"><input type="text"  name="Tools" value=<%=pojo.getTools()%>></td>
	  <td class="td"><input type="text" name="Working_Principle" value="<%=pojo.getWorking_Principle() %>"></td>
   </tbody>
     
      <tr>
      <td><input type="submit"  value="submit"></td>
 
     </tr>
  </table>
 </form>
<%}else{%><form action="update">
  <div align="center" >
   <div><h1>Do not enter the wrong id no</h1></div>
   <div id="button2"><input type="submit"  value="Return"></div>
   </div>
    <img id="image" alt="" src="https://cdnb.artstation.com/p/assets/images/images/050/382/495/large/felipe-baquero-khaby1-portfolio.jpg?1654710931">
    <%} %>
</form>
</body>
</html>