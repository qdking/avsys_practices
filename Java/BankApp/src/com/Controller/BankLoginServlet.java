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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/BankLoginServlet")
public class BankLoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		BankModel m = new BankModel();
		
		m.setEmail(username);
		m.setPassword(password);
		
		int x = m.login();
		if (x == 0)
		{
			resp.sendRedirect("login.jsp");
			System.out.println("Failed to login.");
		}
		else
		{
			// Get and set the login session username and name for verification purposes later on
			HttpSession session = req.getSession(true);
			String name = m.getName();
			String email = m.getEmail();
			int bank_account_number = m.getBank_account_number();
			double balance = m.getBalance();
			int user_id = m.getUser_id();


			session.setAttribute("name", name);
			session.setAttribute("username", username);
			session.setAttribute("email", email);
			session.setAttribute("balance", balance);
			session.setAttribute("bank_account_number", bank_account_number);
			session.setAttribute("user_id", user_id);
			
			
			// Redirect to homepage after successful login
			resp.sendRedirect("home.jsp");
		}
		
	}

}
