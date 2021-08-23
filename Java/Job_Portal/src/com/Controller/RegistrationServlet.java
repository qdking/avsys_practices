package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Model.UserModel;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String confirm_password = req.getParameter("confirm_password");
		
		if (password.equals(confirm_password))
		{
			UserModel m = new UserModel();
			m.setName(name);
			m.setEmail(email);
			m.setPassword(password);
			
			int x = m.register();
			if (x == 0)
			{
				System.out.println("Registration is not successful.");
				resp.sendRedirect("registerNotSuccess.html");
			}
			else if (x == 1)
			{
				System.out.println("Registration is successful.");
				resp.sendRedirect("registerSuccess.html");
			}
			else if (x == 2)
			{
				System.out.println("Email is already existing in the database.");
				resp.sendRedirect("emailExists.html");
			}
		}
		else
		{
			resp.sendRedirect("noMatch.html");
		}
	}

}
