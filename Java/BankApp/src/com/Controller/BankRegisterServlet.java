package com.Controller;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Model.BankModel;

/**
 * Servlet implementation class Model
 */
@WebServlet("/BankRegisterServlet")
public class BankRegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String NRIC = req.getParameter("NRIC");
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String confirm_password = req.getParameter("confirm_password");
		
		// Email variables
		String fromEmail = Credentials.email; //sender's mail id.
		String pwd = Credentials.pwd;		//sender's mail pwd.
		String toEmail = email;

		// Validation: Retyped-password-must-be-the-same 
		if (password.equals(confirm_password))
		{
			BankModel m = new BankModel();
			m.setNRIC(NRIC);
			m.setUsername(username);
			m.setEmail(email);
			m.setPassword(confirm_password);
			
			int x = m.register();
			
			if (x == 0)
			{
				System.out.println("Registration is not successful.");
				resp.sendRedirect("registerNotSuccess.html");
			}
			else if (x == 1)
			{
				System.out.println("Registration is successful.");

				// Send Registration Confirmation Email
				Random rand = new Random();
				int otp = rand.nextInt(900000) + 100000;
				HttpSession sess = req.getSession(true);
				sess.setAttribute("session_otp", otp);
				
				String subject="DO NOT REPLY: GS Bank account registration"; // mail subject line
				String msg="Thank you for register with us, \n Click this link to login: http://localhost:8080/RegisterLoginLogout/login.jsp "
						+ ", and also enter the OTP value to activate your account: " + otp; //mail body
				
				//Creating Session Object
				Properties prop = new Properties();
				prop.put("mail.smtp.host", "smtp.gmail.com");
				prop.put("mail.smtp.port", 587);
				prop.put("mail.smtp.auth", "true");
				prop.put("mail.smtp.starttls.enable", "true");

				Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator()
				{
					protected PasswordAuthentication getPasswordAuthentication()
					{
						//sender's mail id and pwd is encapsulated inside "SendersCredentials.java"
						return new PasswordAuthentication(fromEmail, pwd);
					}
				});

				
				try {
					//Composing the Mail
					MimeMessage mesg = new MimeMessage(session);
					mesg.setFrom(new InternetAddress(fromEmail));
					mesg.addRecipient(Message.RecipientType.TO,new InternetAddress(toEmail));
					mesg.setSubject(subject);  
					mesg.setText(msg);  
					
					//Sending the Mail
					Transport.send(mesg);
					System.out.println("Mail Sent!!");
					resp.sendRedirect("thankyou.html");
					
				} catch (AddressException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
