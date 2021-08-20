package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Model.BankModel;


/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/BankChangePasswordServlet")
public class BankChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	// Get the username from the individual login session
	HttpSession session = req.getSession(true);
	//String username = (String)session.getAttribute("username");
	int user_id= (Integer)session.getAttribute("user_id");
	
	// Get values of the variables from the form
	String password = req.getParameter("password");
	String new_password = req.getParameter("new_password");
	String confirm_password = req.getParameter("confirm_password");


	// Create new model instance to change password of username and old password were correct
	BankModel m = new BankModel();
	

	if (confirm_password.equals(new_password))
	{
		// Setting parameters for SQL 1 to select valid user if the username and current password matches
		m.setUser_id(user_id);
		m.setPassword(password);
		
		// Setting parameters for SQL 2 to set the new password
	
		m.setNew_password(confirm_password);
		
		int x = m.changePassword();
		
		if (x == 1)
		{
			System.out.println("Update is successful");
			System.out.println("The new password was " + req.getParameter("new_password"));
			
			resp.sendRedirect("home.jsp");
		}
		else if (x == 0)
		{
			System.out.println("Update failed.");
			
			resp.sendRedirect("updateFailed.html");
		}
	}

		
	}

}
