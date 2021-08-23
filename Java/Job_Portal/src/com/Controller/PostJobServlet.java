package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Model.DateUtil;
import com.Model.JobModel;

/**
 * Servlet implementation class PostJobServlet
 */
@WebServlet("/PostJobServlet")
public class PostJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	HttpSession session = req.getSession(true);
	
	int user_id = (Integer) session.getAttribute("user_id");
	String job_title = req.getParameter("job_title");
	String job_company = req.getParameter("job_company");
	String job_country = req.getParameter("job_country");
	int job_salary = Integer.parseInt(req.getParameter("job_salary"));
	String job_posted_by = (String) session.getAttribute("name");
	String job_dsecription = req.getParameter("description");
	
	JobModel job = new JobModel();
	job.setUser_id(user_id);
	job.setJob_title(job_title);
	job.setJob_company(job_company);
	job.setJob_country(job_country);
	job.setJob_salary(job_salary);
	job.setJob_posted_by(job_posted_by);
	job.setJob_description(job_dsecription);
	
	int x = job.postJob();
	if (x == 1)
	{
		System.out.println("job posting success.");
		resp.sendRedirect("home.jsp");
	}
	else if (x == 0)
	{
		System.out.println("job posting has failed.");
		resp.sendRedirect("postJob.jsp");
	}
	
	
}

}
