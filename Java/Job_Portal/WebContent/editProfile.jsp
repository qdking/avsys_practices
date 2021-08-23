<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Change Password</title>
	   <link rel = "stylesheet" href = "bootstrap.css">
</head>
<body>
<% 
String change_pass_jsp_username = (String)session.getAttribute("username");
System.out.println("The Change Password JSP session get attribute for username is " + change_pass_jsp_username);
%>

<h1>For now, it's change password only</h1>

	<form action = "ChangePasswordServlet" method = "POST">
		<table>
			<tr>
				<td>Current Password</td>
				<td><input type = "password" name = "password"></td> 
			</tr>
			<tr>
			<td>New Password</td>
				<td><input type = "password" name = "new_password"></td> 
			</tr>
			<tr>
				<td> </td>
				<td><input type = "submit" value = "Change"></td>
			</tr>
		</table>
	</form>
	
</body>
<script src="jquery.min.js.download"></script>
<script src="bootstrap.bundle.min.js.download"></script>
<script src="custom.js.download"></script>
</html>