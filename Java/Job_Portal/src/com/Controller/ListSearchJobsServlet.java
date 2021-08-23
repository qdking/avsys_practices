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
 * Servlet implementation class ListSearchJobsServlet
 */
@WebServlet("/ListSearchJobsServlet")
public class ListSearchJobsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession sess = req.getSession();
		
		JobModel jm = new JobModel();
		
		String searchCriteria = req.getParameter("searchCriteria");
		System.out.println("search criteria is " + searchCriteria);
		
		if (searchCriteria == null && req.getParameter("minimumSalary") == null)
		{
			System.out.println("search criteria is null");
			
			// Call every jobs available in the database
			sess.setAttribute("job_list", jm.jobListing());

			// Redirect to the joblist webpage
			resp.sendRedirect("jobList.jsp");
		}
		
		else if (searchCriteria != null || req.getParameter("minimumSalary") != null)
		{
			System.out.println("search criteria or minimum salary were not null");
			int minimumSalary;
			
			if (req.getParameter("minimumSalary") == null || req.getParameter("minimumSalary") == "")
			{
				 minimumSalary = 0;
			}
			else
			{
				minimumSalary = Integer.parseInt(req.getParameter("minimumSalary"));
			}
			
			System.out.println("min salary in int is " + minimumSalary);
			
			// Call the ArrayList method to get the Jobs Listing results and return an arrayList
			sess.setAttribute("job_list", jm.searchJobs(searchCriteria, minimumSalary));

			// Redirect to the joblist webpage
			resp.sendRedirect("jobList.jsp");
		}
	}

}
