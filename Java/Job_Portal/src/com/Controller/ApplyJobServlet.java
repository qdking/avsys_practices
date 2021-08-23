package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Model.JobModel;

/**
 * Servlet implementation class ApplyJobServlet
 */
@WebServlet("/ApplyJobServlet")
public class ApplyJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		JobModel jm = new JobModel();
		jm.setJob_id(Integer.parseInt(req.getParameter("job_id")));
		jm.setUser_id(Integer.parseInt(req.getParameter("user_id")));
		jm.setJob_title(req.getParameter("job_title"));
		jm.setApplicant_name(req.getParameter("name"));
		
		int x = jm.applyJob();
		if (x == 1)
		{
			System.out.println("Job application successful");
			resp.sendRedirect("home.jsp");
		}
		else 
		{
			System.out.println("Job application failed.");
			
		}

	}

}
