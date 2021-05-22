<%@page import="com.wcs.app.MvcCrud.Model.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<link type="text/css" rel="stylesheet" href="common.css" >

<title>Update Data</title>
</head>

<body class="body" >

<br><br><br><br><br><br>
<%String s=(String)request.getAttribute("msg");%>
<%List<Employee>emplist=(List<Employee>)request.getAttribute("empdata"); %>

<form action="update" method="get" >
	
	<%for (Employee em:emplist)
	{%>
	
<table align="center" >	
<tr>
<th>Name</th>
<td><input type="text" name="name" class="textbox" value="<%=em.getName() %>" ></td>
</tr>

<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>

<tr>
<th>Address</th>
<td><input type="text" name="address" class="textbox" value="<%=em.getAddress() %>" ></td>
</tr>

<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>

<tr>
<th>Age</th>
<td><input type="text" name="age" class="textbox"  value="<%=em.getAge() %>" ></td>
</tr>

<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>

<tr>
<th>MobileNo</th>
<td><input type="text" name="mobileno" class="textbox" value="<%=em.getMobileno() %>" ></td>
</tr>

<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>

<tr>
<th>Salary</th>
<td><input type="text" name="salary" class="textbox" value="<%=em.getSalary() %>" ></td>
</tr>

<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>


<tr>
<th>Password</th>
<td><input type="text" name="password" class="textbox"  value="<%=em.getPassword() %>" ></td>
</tr>
	
</table>	
	<%} %>
	
<center>
<pre>
	
     <input type="submit" value="Update" class="button">
     
<b><%=s %></b>
</pre>
</center>
</form>

</body>
</html>