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
 * Servlet implementation class ResetPasswordServlet
 */
@WebServlet("/ResetPasswordServlet")
public class ResetPasswordServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int userOtp = Integer.parseInt(req.getParameter("otp"));
		String new_password = req.getParameter("new_password");
		String confirm_password = req.getParameter("confirm_password");
		
		HttpSession sess = req.getSession();
		String email = (String)sess.getAttribute("email");
		int session_otp = (Integer)sess.getAttribute("session_otp");
		
		if (userOtp == session_otp && confirm_password.equals(new_password))
		{
			UserModel m = new UserModel();
			m.setEmail(email);
			m.setNew_password(confirm_password);
			
			int x = m.resetPassword();
			if (x == 1)
			{
				System.out.println("Password changed successfully.");
				sess.setAttribute("password_changed", 1);
				resp.sendRedirect("login.jsp");
			}
			else
			{
				System.out.println("Password failed to change.");
			}
		}
		else if (userOtp != session_otp)
		{
			System.out.println("OTP is incorrect.");
		}
		
		
	}
}
