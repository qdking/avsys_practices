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
 * Servlet implementation class TransferMoneyServlet
 */
@WebServlet("/TransferMoneyServlet")
public class TransferMoneyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Get the username from the individual login session
		HttpSession session = req.getSession(true);
		
		int user_id = (Integer)session.getAttribute("user_id");
		int target_banknumber = Integer.parseInt(req.getParameter("receipient_bank_account_number"));
		
		double balance = (Double)session.getAttribute("balance");
		double transfer_amount = Double.parseDouble(req.getParameter("transfer_amount"));
		
		// Getting Email variables
		String fromEmail = Credentials.email; //sender's mail id.
		String pwd = Credentials.pwd;		//sender's mail pwd.
		
		String toTransfererEmail= (String)session.getAttribute("email");


		
		// Create new model instance to change password of username and old password were correct
		BankModel m = new BankModel();
		
		if (transfer_amount > 0 && balance - transfer_amount > 0)
		{
			m.setUser_id(user_id);
			m.setBank_account_number(target_banknumber);
			m.setBalance(balance);
			m.setTransfer_money_amount(transfer_amount);
			
			int x = m.transferMoney();
			
			if (x == 1)
			{
				// Update new balance amount in to the redirecting homepage 
				session.setAttribute("balance", m.getBalance());
				System.out.println("Transferring money is successful and the new balance in the Servlet is " + m.getBalance());
				resp.sendRedirect("home.jsp");
				
				// Email Notification to both users 
				HttpSession sess = req.getSession(true);

				String subject = "GS BANK NOTIFICATION: Money Transferred from your Account (DO NOT REPLY) "; // mail subject line
				String msg = "Bank Notification: you have just transferred $" + transfer_amount + " to Bank account number " 
						+ target_banknumber + ".\n\nPlease contact our bank if you did not do this. (DO NOT REPLY TO THIS EMAIL). Thank you."; 
				
				//Creating Session Object
				Properties prop = new Properties();
				prop.put("mail.smtp.host", "smtp.gmail.com");
				prop.put("mail.smtp.port", 587);
				prop.put("mail.smtp.auth", "true");
				prop.put("mail.smtp.starttls.enable", "true");

				Session session2 = Session.getDefaultInstance(prop, new javax.mail.Authenticator()
				{
					protected PasswordAuthentication getPasswordAuthentication()
					{
						//sender's mail id and pwd is encapsulated inside "SendersCredentials.java"
						return new PasswordAuthentication(fromEmail, pwd);
					}
				});

				
				try {
					//Composing the Mail
					MimeMessage mesg = new MimeMessage(session2);
					mesg.setFrom(new InternetAddress(fromEmail));
					mesg.addRecipient(Message.RecipientType.TO,new InternetAddress(toTransfererEmail));
					mesg.setSubject(subject);  
					mesg.setText(msg);  
					
					//Sending the Mail
					Transport.send(mesg);
					System.out.println("Mail Sent!!");

					
				} catch (AddressException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else if (x == 0)
			{
				System.out.println("Transferring money was not successful.");
			}
		}
		if (transfer_amount <= 0)
		{
			System.out.println("Please input a positive number. Thank you.");
		}
		if (balance - transfer_amount <= 0)
		{
			System.out.println("Not enough money in your account.");
		}
		

	}
}
