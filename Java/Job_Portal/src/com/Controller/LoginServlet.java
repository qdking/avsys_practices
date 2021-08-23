package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Model.UserModel;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");
		System.out.println("parameter gotten from form email is " + email);
		System.out.println("parameter gotten from form password is " + password);
		
		UserModel m = new UserModel();
		
		m.setEmail(email);
		m.setPassword(password);
		
		int x = m.login();
		if (x == 0)
		{
			resp.sendRedirect("loginFail.html");
		}
		// If successful login is executed
		else if (x == 1)
		{
			// Get and set the login session variables for verification purposes later on in other pages
			HttpSession session = req.getSession(true);
			String name = m.getName();
			int role_id = m.getRole_id();
			int user_id = m.getUser_id();

			session.setAttribute("user_id", user_id);
			session.setAttribute("name", name);
			session.setAttribute("email", email);
			session.setAttribute("role_id", role_id);
			
			System.out.println("the session name is " + name);
			
			// Redirect to homepage after successful login
			resp.sendRedirect("home.jsp");
		}
	}

}
