<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page	import = "java.util.ArrayList" %>
<%@page import = "com.Model.JobModel" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Job List</title>
	    <link rel="stylesheet" href="bootstrap_archive/bootstrap.css">
</head>
<body>

			<div class="row">
			  <div class="col-lg-12">
				  <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
					<a class="navbar-brand" href="home.jsp">Home</a>
					<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
					  <span class="navbar-toggler-icon"></span>
					</button>
	
					<div class="collapse navbar-collapse" id="navbarColor01">
					  <ul class="navbar-nav mr-auto">
						<li class="nav-item dropdown">
						  <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Me</a>
						  <div class="dropdown-menu">
							<a class="dropdown-item" href="#">View Profile</a>   
							<a class="dropdown-item" href="#">Change Password</a>
							<a class="dropdown-item" href="#">Career Experience</a>
							<a class="dropdown-item" href="#">Qualifications</a>
							<a class="dropdown-item" href="#">My Connections</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="LogoutServlet">Log Out</a>
						  </div>
						</li>
						<li class="nav-item dropdown">
						  <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="jobList" role="button" aria-haspopup="true" aria-expanded="true">Jobs</a>
						  <div class="dropdown-menu ">
							<a class="dropdown-item" href="jobList.jsp">Search Jobs</a>
							<a class="dropdown-item" href="postJob.jsp">Post Jobs</a>
							<a class="dropdown-item" href="jobsPosted">Jobs Posted By You</a>
							<a class="dropdown-item" href="#">Jobs Applied</a>
						  </div>
						  </li>
						  <li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="jobList" role="button" aria-haspopup="true" aria-expanded="true">Forum</a>
							<div class="dropdown-menu ">
							  <a class="dropdown-item" href="#">Career</a>
							  <a class="dropdown-item" href="#">Learning</a>
							  <a class="dropdown-item" href="#">Chat</a>
							</div>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="#">Messaging</a>
							</li>
					  </ul>
					  <form class="form-inline my-2 my-lg-0" action ="searchUsers">
						<input class="form-control mr-sm-2" type="text" placeholder="Search Users" name = "searchCriteria">
						<button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
					  </form>
					</div>
				  </nav>
			  </div>
			</div>
			
<div style = "width: 40%; margin: auto;">
	<div style = "width:40%; margin-left: 20%; margin-right: 10%;">
		<h1>Job List</h1>
		<form action = "ListSearchJobsServlet" method = "GET">
			<table style = "border-spacing: 10px;">
		                <tr>
		                    <td>Job Search</td>
		                    <td><input type = "text" name = "searchCriteria"></td> 
		                </tr>
		                <tr>
		                    <td>Minimum Salary Range</td>
		                    <td><input type = "text" name = "minimumSalary"></td> 
		                </tr>
		                <tr>
		                    <th colspan="2" style = "text-align: center;"><input type = "submit" value = "Search" class="btn btn-primary"></th>
		                </tr>
		    </table>
		    <br>
		</form>
	</div>    
	<table style = "text-align:center;">
		<tr>
			<th>No.</th>
			<th>Job Title</th>
			<th>Job Company</th>
			<th>Country</th>
			<th>Salary Range</th>
			<th>Posted By</th>
			<th>Date Posted</th>
		</tr>
			<% ArrayList job_list = (ArrayList)session.getAttribute("job_list"); %>
			<% for (int i = 0; i < job_list.size(); i++) { %>
				<tr>
					<% JobModel job_model = (JobModel) job_list.get(i); %> 
					<td id = "job_id"><a href = "ViewJobDetailsServlet?job_id=1">
					<%  out.print(job_model.getJob_id());%> 
					</a></td>
					<td><a href = "ViewJobDetailsServlet?job_id=<%out.print(job_model.getJob_id());%>">
					<%  out.print(job_model.getJob_title());%> 
					</a></td>
					<td>
					<%  out.print(job_model.getJob_company());%> 
					</td>
					<td>
					<%  out.print(job_model.getJob_country());%> 
					</td>
					<td>
					<%  out.print(job_model.getJob_salary());%> 
					</td>
					<td>
					<%  out.print(job_model.getJob_posted_by());%> 
					</td>
					<td>
					<%  out.print(job_model.getJob_date());%> 
					</td>
				</tr>
				<%}
			%>
	</table>
	</div>
	
	
<div>
<hr>
    <p style = "text-align: center;">Orange and Teal Copyright 2021</p>
</div>


    <script src="Bootswatch_ Superhero_files/jquery.min.js.download"></script>
    <script src="Bootswatch_ Superhero_files/bootstrap.bundle.min.js.download"></script>
    <script src="Bootswatch_ Superhero_files/custom.js.download"></script>
			
</body>
</html>