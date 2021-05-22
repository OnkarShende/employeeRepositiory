<%@page import="com.wcs.app.MvcCrud.Model.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="common.css" >

<script type="text/javascript">

function del() 
{
	alert("This Account will Delete Permanantly.")
	document.myform.action="delete";
	document.myform.submit();
	
}

function edit() 
{
	document.myform.action="edit";
	document.myform.submit();
	
}

</script>

<style type="text/css">
table, th, td
{
	  border: 1px solid black;
	  border-collapse: collapse;
	/*   background-color: black; */
	
}
</style>

<title>LoginSuccess</title>
</head>

<body class="body" >

<br><br><br><br><br><br><br><br><br><br><br><br>

<form name="myform" method="get" >

<%List<Employee> emplist=(List)request.getAttribute("empdata");%>

<font color="white" >

<table align="center"> 

<tr>
<th>Select</th>
<th>Employee Id</th>
<th>UserName</th>
<th>Password</th>
<th>Name</th>
<th>Address</th>
<th>Age</th>
<th>Mobile No</th>
<th>Salary</th>
</tr>

	<%for(Employee em:emplist)
		{%>
		
		<tr>
		<td><input type="radio" name="empid" value="<%=em.getEmpid() %>" > </td>
		<td align="center" > <%=em.getEmpid() %></td>
		<td> <%=em.getUsername() %></td>
		<td> <%=em.getPassword() %></td>
		<td> <%=em.getName() %></td>
		<td> <%=em.getAddress() %></td>
		<td> <%=em.getAge() %></td>
		<td> <%=em.getMobileno() %></td>
		<td> <%=em.getSalary() %></td>
		</tr>
	
	<%} %>
	
<tr>

</table>
<br>

</font>

<center>
<input type="button" value="Delete" class="button" onclick="del()"> <input type="button" value="Edit" class="button" onclick="edit()">   <a href="Login.jsp" ><input type="button" value="Logout" class="button"></a>
</center>


</form>

</body>
</html>