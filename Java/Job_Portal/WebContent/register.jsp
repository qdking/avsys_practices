<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Register</title>
	<link rel="stylesheet" href= "bootstrap_archive/bootstrap.css">
</head>
<body>


<div class = "form-body">
	<div class = "form-body register-body" style = "padding-left = 90px;">
        <form action = "RegistrationServlet"  method = "POST">
            <table style = "border-spacing: 10px;">
                <tr>
                    <td>Name</td>
                    <td><input type = "text" name = "name"></td> 
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type = "email" name = "email"></td> 
                </tr>
                <tr>
                <td>Password</td>
                    <td><input type = "password" name = "password"></td> 
                </tr>
                <tr>
                    <td>Confirm Password &nbsp;</td>
                    <td><input type = "password" name = "confirm_password"></td> 
                </tr>
                <tr> <td> &nbsp;</td></tr>
                <tr>
                    <th colspan="2" style = "text-align: center;"><input type = "submit" value = "Register" class="btn btn-register"></th>
                </tr>
            </table>
        </form>
    </div>
</div>
	<br>
	<p style = "text-align:center; font-size: 16px;">Already have an account? Click <a href ="login.jsp">here</a> to login.</p>

</body>
    <script src="Bootswatch_ Superhero_files/jquery.min.js.download"></script>
    <script src="Bootswatch_ Superhero_files/bootstrap.bundle.min.js.download"></script>
    <script src="Bootswatch_ Superhero_files/custom.js.download"></script>
</html>