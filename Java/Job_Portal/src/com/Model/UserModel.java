package com.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {
	// Declaring variables
	PreparedStatement pstmt;
	Connection con;
	ResultSet res;
	
	private int user_id;
	private int role_id;
	private String name;
	private String email;
	private String password;
	private String new_password;
		
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getNew_password() {
		return new_password;
	}
	public void setNew_password(String new_password) {
		this.new_password = new_password;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	// Constructor - standard behaviour to get the Driver and Connect to the DXCTraining database.
	public UserModel()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is successfully loaded.");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/avensys_jobportal?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC", "sql_username", "sql_password);
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
		String sql = "INSERT INTO userprofile(name, password, email) VALUES (?, ?, ?)";
		
		// Prepare statement to execute SQL query, return 1 if successful, otherwise return 0. 
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			pstmt.setString(3, email);
			
			// If email does not exist in the database
			if (emailExists() == 0)
			{
				int x = pstmt.executeUpdate();
				return x;
			}
			else
			{
				System.out.println("Email is already existing in the database.");
				return 2;
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	// Login  method
	public int login()
	{
		String sql = "SELECT * FROM userprofile WHERE email = ? AND password = ?";
		
		// Prepare statement to execute SQL query, return 1 if successful, otherwise return 0. 
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			
			// If email does not exist in the database
			if (emailExists() == 0)
			{
				System.out.println("Email does not exist in the database.");
				return 0;
			}
			else
			{
				res = pstmt.executeQuery();
				
				if (res.next() == true)
				{
					user_id = res.getInt("user_id");
					name = res.getString("name");
					email = res.getString("email");
					role_id = res.getInt("role_id");

					return 1;
				}
				else 
				{
					return 0;
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;

		}
	}
	
	// Preventing duplicate Email values in database + Validate existence of an email value in the database 
	
	public int emailExists()
	{
		String sql = "SELECT * FROM userprofile WHERE email = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			res = pstmt.executeQuery();
			
			if (res.next() == true)
			{
				email = res.getString("email");

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
	
	// Change Profile or Password method (UNUSED!!!!)
	public int changePassword()
	{
		
		String sql1 = "SELECT * FROM userprofile where email = ? AND password = ?";

		// Fetch users profile 
		try {
			pstmt = con.prepareStatement(sql1);
			
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			
			res = pstmt.executeQuery();
			
			// Prepare statement to execute SQL query, return 1 if successful, otherwise return 0. 
			// Change profile/password
			if (res.next() == true)
			{
				String sql2 = "UPDATE users SET password = ? WHERE email = ?";
				pstmt = con.prepareStatement(sql2);
				
				pstmt.setString(1, new_password);
				pstmt.setString(2, email);
				
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

	// Change Password method
	public int resetPassword()
	{
		String sql = "UPDATE userprofile SET password = ? WHERE email = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, new_password);
			pstmt.setString(2, email);
			
			int x = pstmt.executeUpdate();
			return x;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}
}

