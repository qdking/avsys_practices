<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Reset Password</title>
	<link rel="stylesheet" href= "bootstrap_archive/bootstrap.css">
</head>
<body>
<% System.out.println("The session value gotten for OTP is " + session.getAttribute("session_otp")); %>



<div class = "form-body">
<h1> Reset Password </h1>
	<div class = "form-body register-body">
		<form action = "ResetPasswordServlet" method = "POST">
			<table>
				<tr>
					<td>OTP</td>
					<td><input type = "text" name = "otp"></td> 
				</tr>
				<tr>
					<td>New Password</td>
					<td><input type = "password" name = "new_password"></td> 
				</tr>
				<tr>
				<td>Confirm Password &nbsp;</td>
					<td><input type = "password" name = "confirm_password"></td> 
				</tr>
                <tr><td>&nbsp;</td></tr>
				<tr>
                    <td colspan="2" style = "text-align: center;"><input type = "submit" value = "Reset" class="btn btn-primary"></td>
				</tr>
			</table>
		</form>
	</div>
</div>
</body>

    <script src="Bootswatch_ Superhero_files/jquery.min.js.download"></script>
    <script src="Bootswatch_ Superhero_files/bootstrap.bundle.min.js.download"></script>
    <script src="Bootswatch_ Superhero_files/custom.js.download"></script>

</html>