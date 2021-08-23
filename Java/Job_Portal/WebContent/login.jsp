<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="bootstrap_archive/bootstrap.css">

</head>
<body>

<div class = "form-body">
<% 
/* if ((Integer)session.getAttribute("changed_password") == 1)
{
	out.println("Password has been changed successfully!"); 
}
 */
%>
	<div class = "form-body login-body">
		<form action = "LoginServlet" method = "POST">
			<table>
				<tr>
					<td>Email</td>
					<td><input type = "text" name = "email"></td> 
				</tr>
				<tr>
				<td>Password &nbsp;</td>
					<td><input type = "password" name = "password"></td> 
				</tr>
                <tr><td>&nbsp;</td></tr>
				<tr>
                    <td colspan="2" style = "text-align: center;"><input type = "submit" value = "Login"class="btn btn-primary"></td>
				</tr>
			</table>
		</form>
	</div>
</div>

	<p class = "after-form-body">		
	<br>	
		<a href = "forgotPassword.html">Forgot Password</a>
			<br>
		Don't have an account yet? Click <a href = "register.jsp">here</a> to register an account.
	</p>
	


    <script src="./Bootswatch_ Superhero_files/jquery.min.js.download"></script>
    <script src="./Bootswatch_ Superhero_files/bootstrap.bundle.min.js.download"></script>
    <script src="./Bootswatch_ Superhero_files/custom.js.download"></script>


</body>
</html>