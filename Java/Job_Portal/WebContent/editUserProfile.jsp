<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
String editprofile_jsp_username = (String)session.getAttribute("username");
System.out.println("The Edit Profile JSP session get attribute for username is " + editprofile_jsp_username);
%>

<h1>For now, it's change password only</h1>

	<form action = "EditProfileServlet">
		<table>
			<tr>
				<td>Current Password</td>
				<td><input type = "password" name = "password"></td> 
			</tr>
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
				<td><input type = "submit" value = "SUBMIT"></td>
			</tr>
		</table>
	</form>
	
</body>
</html>