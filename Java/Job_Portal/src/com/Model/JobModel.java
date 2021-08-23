package com.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


public class JobModel {
	// Declaring variables
	PreparedStatement pstmt;
	Connection con;
	ResultSet res;
	
	private int user_id;
	private int job_id;
	private String job_title;
	private String job_company; 
	private String job_country;
	private int job_salary;
	private String job_posted_by;
	private String job_date; 
	private String job_description;
	private ArrayList<JobModel> joblistall;
	
	private String applicant_name;
	

	public String getApplicant_name() {
		return applicant_name;
	}
	public void setApplicant_name(String applicant_name) {
		this.applicant_name = applicant_name;
	}
	public ArrayList<JobModel> getJoblistall() {
		return joblistall;
	}
	public void setJoblistall(ArrayList<JobModel> joblistall) {
		this.joblistall = joblistall;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getJob_id() {
		return job_id;
	}
	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	public String getJob_company() {
		return job_company;
	}
	public void setJob_company(String job_company) {
		this.job_company = job_company;
	}
	public String getJob_country() {
		return job_country;
	}
	public void setJob_country(String job_country) {
		this.job_country = job_country;
	}
	public int getJob_salary() {
		return job_salary;
	}
	public void setJob_salary(int job_salary) {
		this.job_salary = job_salary;
	}
	public String getJob_posted_by() {
		return job_posted_by;
	}
	public void setJob_posted_by(String job_posted_by) {
		this.job_posted_by = job_posted_by;
	}
	public String getJob_date() {
		return job_date;
	}
	public void setJob_date(String job_date) {
		this.job_date = job_date;
	}
	public String getJob_description() {
		return job_description;
	}
	public void setJob_description(String job_description) {
		this.job_description = job_description;
	}
	
	// Constructor - standard behaviour to get the Driver and Connect to the DXCTraining database.
	public JobModel()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is successfully loaded.");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/avensys_jobportal?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC", "sql_user", "sql_password");
			System.out.println("Connected to database");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public JobModel(int job_id, int user_id, String job_title, String job_company, String job_country, int job_salary, String job_posted_by,
			String job_description, String job_date) {
		// TODO Auto-generated constructor stub

	}
	// Job Posting method
	public int postJob()
	{
		String sql = "INSERT INTO jobs (user_id, job_title, job_company, job_salary, job_posted_by, job_date, job_description. job_country)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		// Prepare statement to execute SQL query, return 1 if successful, otherwise return 0. 
		try {
			pstmt = con.prepareStatement(sql);
			
			Date system_date = new Date(System.currentTimeMillis());
			
			pstmt.setInt(1, user_id);
			pstmt.setString(2, job_title);
			pstmt.setString(3, job_company);
			pstmt.setInt(4, job_salary);
			pstmt.setString(5, job_posted_by);
			pstmt.setString(6, DateUtil.dateToString(system_date));
			pstmt.setString(7, job_description);
			pstmt.setString(8, job_country);
			
			int x = pstmt.executeUpdate();
			return x;


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	// Job Application method
	
	public int applyJob()
	{
		String sql = "INSERT INTO job_applications (job_id, user_id, job_title, applicant_name, application_date)"
				+ " VALUES (?, ?, ?, ?, ?)";
		
		// Prepare statement to execute SQL query, return 1 if successful, otherwise return 0. 
		
		try {
			pstmt = con.prepareStatement(sql);
			
			Date system_date = new Date(System.currentTimeMillis());
			
			pstmt.setInt(1, job_id);
			pstmt.setInt(2, user_id);
			pstmt.setString(3, job_title);
			pstmt.setString(4, applicant_name);
			pstmt.setString(5, DateUtil.dateToString(system_date));
			
			int x = pstmt.executeUpdate();
			return x;


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}
	
	// Return a list of Jobs Posted
	public ArrayList<JobModel> jobListing()
	{
		String sql = "SELECT * FROM jobs";
		
		try {
			pstmt = con.prepareStatement(sql);
						
			res = pstmt.executeQuery();
			joblistall = new ArrayList<JobModel>();
			

			if (res != null)
			{
				while (res.next())
				{
/*					job_model = new JobModel(
							res.getInt("job_id"),
							res.getInt("user_id"),
							res.getString("job_title"),
							res.getString("job_company"),
							res.getString("job_country"),
							res.getInt("job_salary"),
							res.getString("job_posted_by"),
							res.getString("job_description"),
							res.getString("job_date")
							);
*/					JobModel job_model = new JobModel();

					job_model.setJob_id(res.getInt("job_id"));
					job_model.setUser_id(res.getInt("user_id"));
					job_model.setJob_title(res.getString("job_title"));
					job_model.setJob_company(res.getString("job_company"));
					job_model.setJob_country(res.getString("job_country"));
					job_model.setJob_salary(res.getInt("job_salary"));
					job_model.setJob_posted_by(res.getString("job_posted_by"));
					job_model.setJob_description(res.getString("job_description"));
					job_model.setJob_date(res.getString("job_date"));
					
					
					// Append to ArrayList joblistall, but it fails to do so?
					joblistall.add(job_model);
					//System.out.println("Job Model inserted into arraylist");
				}
			}
		
		return joblistall;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Failed to add anything into the arraylist.");
			return null;
		}
	}
	
	// Searches a list of Jobs Posted with search criteria
	public ArrayList<JobModel> searchJobs(String searchCriteria, int minimumSalary)
	{
		String sql = "SELECT *"
				+ " FROM jobs WHERE job_salary >= ? AND (job_country LIKE ? OR job_title LIKE ? OR job_company LIKE ?)";

		try {		

		pstmt = con.prepareStatement(sql);
		
		searchCriteria = "%" + searchCriteria + "%";
			
			pstmt.setInt(1, minimumSalary);
			pstmt.setString(2, searchCriteria);
			pstmt.setString(3, searchCriteria);
			pstmt.setString(4, searchCriteria);
			
		
			res = pstmt.executeQuery();
			ArrayList<JobModel> joblistall = new ArrayList<JobModel>();
			
			if (res != null)
			{
				while (res.next())
				{	
					JobModel job_model = new JobModel();
					
					job_model.setJob_id(res.getInt("job_id"));
					job_model.setUser_id(res.getInt("user_id"));
					job_model.setJob_title(res.getString("job_title"));
					job_model.setJob_company(res.getString("job_company"));
					job_model.setJob_country(res.getString("job_country"));
					job_model.setJob_salary(res.getInt("job_salary"));
					job_model.setJob_posted_by(res.getString("job_posted_by"));
					job_model.setJob_description(res.getString("job_description"));
					job_model.setJob_date(res.getString("job_date"));
					
					joblistall.add(job_model);
					//System.out.println("Job Model inserted into arraylist");
				}
			}
			
		return joblistall;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Failed to add anything into the arraylist.");
			return null;
		}
	}
	
	// View Jobs Posted
	public void viewJobDetails()
	{
		String sql = "SELECT * FROM jobs WHERE job_id = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, job_id);
			ResultSet res = pstmt.executeQuery();
			
			if (res.next() == true)
			{
				job_id = res.getInt("job_id");
				user_id = res.getInt("user_id");
				job_title = res.getString("job_title");
				job_company = res.getString("job_company");
				job_salary = res.getInt("job_salary");
				job_posted_by = res.getString("job_posted_by");
				job_description = res.getString("job_description");
				job_country = res.getString("job_country");
				System.out.println("Successfully retrived job details and the job title gotten is " + job_title);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return (job_id + " " + job_title + " " + job_company + " " + job_salary + " " + job_posted_by + " " + job_country);
	}
	
	
	
}
