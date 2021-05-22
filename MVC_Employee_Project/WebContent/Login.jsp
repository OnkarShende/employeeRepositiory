<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<link type="text/css" rel="stylesheet" href="common.css">

<style type="text/css">

input
 {
	 border: 2px solid black;
  	 border-radius: 10px;	
}


</style>

<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>

<body class="body">

<br><br><br><br><br>

<form action="login" method="post" >

<table align="center">

<tr>
<th> UserName</th>
<td> <input type="text" name="username" placeholder="Enter Username"  required="required"></td>
</tr>

<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>

<tr>
<th>Password</th>
<td> <input type="password" name="password" placeholder="Enter Password"  required="required"></td>
</tr>

<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>

<tr>
<td colspan="3" >
 &nbsp&nbsp <input type="submit" class="button"  value="Login">
<input type="reset"  class="button" value="Reset">
<a href="Register.jsp" > <input class="button" type="button" value="Register"></a>
</td>
</tr>

</table>

</form>

<%String s=(String)request.getAttribute("msg");%>

<%if(s!=null)
	{%>
	
	<%=s %>
	
	<%} %>

</body>
</html>