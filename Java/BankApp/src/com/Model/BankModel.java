package com.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankModel {

	// Declaring variables
	PreparedStatement pstmt;
	Connection con;
	ResultSet res;
	
	private int user_id;
	private int bank_account_number;
	private String username;
	
	private String NRIC;
	private String email;
	private String name;
	private String password;
	
	private double deposit_money;
	private double balance;
	private double transfer_money_amount;
	
	private String new_password;
	
	
	public double getTransfer_money_amount() {
		return transfer_money_amount;
	}

	public void setTransfer_money_amount(double transfer_money_amount) {
		this.transfer_money_amount = transfer_money_amount;
	}

	public double getDeposit_money() {
		return deposit_money;
	}

	public void setDeposit_money(double deposit_money) {
		this.deposit_money = deposit_money;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getBank_account_number() {
		return bank_account_number;
	}

	public void setBank_account_number(int bank_account_number) {
		this.bank_account_number = bank_account_number;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNRIC() {
		return NRIC;
	}

	public void setNRIC(String nRIC) {
		NRIC = nRIC;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getNew_password() {
		return new_password;
	}

	public void setNew_password(String new_password) {
		this.new_password = new_password;
	}


	public BankModel()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is successfully loaded.");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dxctraining?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC", "your_SQL_username", "your_password");
			System.out.println("Connected to database");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Register users method
	public int register()
	{
		String sql = "INSERT INTO bankapp (NRIC, username, email, password, bank_account_number) VALUES (?, ?, ?, ?, ?)";
		
		// Prepare statement to execute SQL query, return 1 if successful, otherwise return 0. 
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, NRIC);
			pstmt.setString(2, username);
			pstmt.setString(3, email);
			pstmt.setString(4, password);
			pstmt.setInt(5, (int)(10000000 + Math.random() * (90000000 - 10000000)));
			
			int x = pstmt.executeUpdate();
			return x;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	// Login  method
	public int login()
	{
		String sql = "SELECT * FROM bankapp WHERE username = ? AND password = ?";
		
		// Prepare statement to execute SQL query, return 1 if successful, otherwise return 0. 
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, email);
			pstmt.setString(2, password);

			res = pstmt.executeQuery();
			
			if (res.next() == true)
			{
				user_id = res.getInt("user_id");
				username = res.getString("username");
				balance = res.getDouble("balance");
				bank_account_number = res.getInt("bank_account_number");
				email = res.getString("email");
				
				System.out.println("In model, the retrieved username is " + username);
				
				System.out.println("In model, the retrieved user id  is " + user_id);
				
				return 1;
			}
			else 
			{
				return 0;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;

		}

	}
	
	// Change Password method
	public int changePassword()
	{
		
		String sql1 = "SELECT * FROM bankapp where user_id = ? AND password = ?";

		// Fetch users profile 
		try {
			pstmt = con.prepareStatement(sql1);
			
			pstmt.setInt(1, user_id);
			pstmt.setString(2, password);
			
			res = pstmt.executeQuery();
			
			// Prepare statement to execute SQL query, return 1 if successful, otherwise return 0. 
			if (res.next() == true)
			{
				String sql2 = "UPDATE bankapp SET password = ? WHERE user_id = ?";
				pstmt = con.prepareStatement(sql2);
				
				pstmt.setString(1, new_password);
				pstmt.setInt(2, user_id);
				
				int x = pstmt.executeUpdate();
				return x;
			}
			else
			{
				return 0;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	
	public int depositMoney()
	{
		String sql = "UPDATE bankapp SET balance = ? + ? WHERE user_id = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setDouble(1, balance);
			pstmt.setDouble(2, deposit_money);
			pstmt.setInt(3, user_id);
			
			int x = pstmt.executeUpdate();
			
			// Fetch the newly updated balance value
			String sql2 = "SELECT balance FROM bankapp WHERE user_id = ?";
			
			PreparedStatement pstmt2 = con.prepareStatement(sql2);
			pstmt2.setInt(1, user_id);
			
			res = pstmt2.executeQuery();
			if (res.next() == true)
			{
				balance = res.getDouble("balance");
				System.out.println("the newly resulting balance in the model is  " + balance);
			}
		
			return x;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	public int transferMoney()
	{
		int x = 0;

		try {
			String sql = "SELECT balance FROM bankapp WHERE bank_account_number = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bank_account_number);
			
			ResultSet res = pstmt.executeQuery();
			
			if (res.next() == true)
			{
				double target_balance = res.getDouble("balance");
				
				String sql2 = "UPDATE bankapp SET balance = ? + ? WHERE bank_account_number = ?";
				
				PreparedStatement pstmt2 = con.prepareStatement(sql2);
				pstmt2.setDouble(1, target_balance);
				pstmt2.setDouble(2, transfer_money_amount);
				pstmt2.setInt(3, bank_account_number);
				
				x = pstmt2.executeUpdate();
				
				if (x == 1)
				{
					String sql3 = "UPDATE bankapp SET balance = ? - ? WHERE user_id = ?";
					
					// Update the balance on user's end
					PreparedStatement pstmt3 = con.prepareStatement(sql3);
					pstmt3.setDouble(1, balance);
					pstmt3.setDouble(2, transfer_money_amount);
					pstmt3.setInt(3, user_id);
					
					pstmt3.executeUpdate();
					
					// Fetch the newly updated balance value to the session later
					String sql4 = "SELECT balance FROM bankapp WHERE user_id = ?";
					
					PreparedStatement pstmt4 = con.prepareStatement(sql4);
					pstmt4.setInt(1, user_id);
					
					res = pstmt4.executeQuery();
					if (res.next() == true)
					{
						balance = res.getDouble("balance");
						System.out.println("the newly resulting balance in the model is  " + balance);
					}
				}
				else
				{
					System.out.println("Failed to transfer money in the model.");
				}
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return x;
	}
	
}
