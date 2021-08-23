<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
	<title>Jobs Posted By User</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
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
							<a class="dropdown-item" href="ListSearchJobsServlet">Search Jobs</a>
							<a class="dropdown-item" href="postJob.jsp">Post Jobs</a>
							<a class="dropdown-item" href="#">Jobs Posted By You</a>
							<a class="dropdown-item" href="#">Jobs Applied</a>
							<a class="dropdown-item" href="#">List Applicants</a>
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
					  <form class="form-inline my-2 my-lg-0" action ="SearchUsersServlet">
						<input class="form-control mr-sm-2" type="text" placeholder="Search Users" name = "searchCriteria">
						<button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
					  </form>
					</div>
				  </nav>
			  </div>
			</div>

	<div style = "width:60%; margin-left: 40%; margin-right: 0%; margin-top: 10%; margin-bottom: 10%;">
	
		<h1>Job Details</h1>
	
		Job No.: <% out.print(session.getAttribute("job_id"));%>
		<br>
		Job title: <% out.print(session.getAttribute("job_title"));%>
		<br>
		Job company: <% out.print(session.getAttribute("job_company"));%>
		<br>
		Country: <% out.print(session.getAttribute("job_country"));%>
		<br>
		Salary: $<% out.print(session.getAttribute("job_salary"));%>
		<br>
		Posted by: <a href = "#"><% out.print(session.getAttribute("job_posted_by"));%></a>
		<br>
		Date Posted: <% out.print(session.getAttribute("job_posted_by"));%>
		<br>
		Description: 
		<p>
		<% out.print(session.getAttribute("job_description"));%>
		</p>
	
	<a href = "ApplyJobServlet?job_id=<% out.print(session.getAttribute("job_id"));%>
	&user_id=<% out.print(session.getAttribute("user_id"));%>
	&job_title=<% out.print(session.getAttribute("job_title"));%>
	&name=<% out.print(session.getAttribute("name"));%>
	">Apply</a>
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

