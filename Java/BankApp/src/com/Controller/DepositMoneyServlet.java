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
 * Servlet implementation class DepositMoneyServlet
 */
@WebServlet("/DepositMoneyServlet")
public class DepositMoneyServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
      
@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	// Get the username from the individual login session
	HttpSession session = req.getSession(true);
	
	int user_id= (Integer)session.getAttribute("user_id");
	
	double balance = (Double)session.getAttribute("balance");
	double deposit = Double.parseDouble(req.getParameter("deposit_amount"));
	
	// Create new model instance to change password of username and old password were correct
	BankModel m = new BankModel();
	
	if (deposit > 0 )
	{
		m.setUser_id(user_id);
		m.setBalance(balance);
		m.setDeposit_money(deposit);
		
		int x = m.depositMoney();
		if (x == 1)
		{
			session.setAttribute("balance", m.getBalance());
			System.out.println("Depositing money is successful and the new amount in the Servlet is " + m.getBalance());
			resp.sendRedirect("home.jsp");
		}
		else if (x == 0)
		{
			System.out.println("Depositing money is not successful.");
		}
	}
	else
	{
		System.out.println("Please input a positive number. Thank you.");
	}

	}
}
