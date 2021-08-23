package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Model.JobModel;

/**
 * Servlet implementation class ViewJobsServlet
 */
@WebServlet("/ViewJobDetailsServlet")
public class ViewJobDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	  	// Calling the View Job Details method 
		JobModel job = new JobModel();
		
		int job_id = Integer.parseInt(req.getParameter("job_id"));
		job.setJob_id(job_id);
		
		job.viewJobDetails();
		
		// Temporarily fixing job_id as one, to be gotten from a session or parameter later on. 
		//int job_id = job.getJob_id();

		
		HttpSession sess = req.getSession();
		//sess.setAttribute("user_id", job.getUser_id());
		sess.setAttribute("job_id", job_id);
		sess.setAttribute("job_title", job.getJob_title());
		sess.setAttribute("job_company", job.getJob_company());
		sess.setAttribute("job_country", job.getJob_country());
		sess.setAttribute("job_salary", job.getJob_salary());
		sess.setAttribute("job_date", job.getJob_date());
		sess.setAttribute("job_posted_by", job.getJob_posted_by());
		sess.setAttribute("job_description", job.getJob_description());
		
		resp.sendRedirect("viewJobDetail.jsp");
		
}

}
