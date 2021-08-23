<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
	<title>Homepage</title>
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
							<a class="dropdown-item" href="#">Jobs Applied</a>
							<% if ((Integer) session.getAttribute("role_id") != 1)
							{
								
							}%>
							<a class="dropdown-item" href="postJob.jsp">Post Jobs</a>
							<a class="dropdown-item" href="#">Jobs Posted By You</a>

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
			
	<div class="jumbotron">
		<h1 class="display-3">Welcome to Job Portal, <% out.println(session.getAttribute("name")); %></h1>
		<p class="lead">After a year of the COVID-19 pandemic, people are re-examining and remaking every part of their lives, especially their jobs.</p>
		<hr class="my-4">
		<p>In another survey, we found that more than 70 percent of employees say that their sense of purpose is defined by their work. Companies that ignore this 
			do so at their peril because employees also say that if their job doesn't give them purpose, they'll leave for one that will.</p>
		<p class="lead">
		  <a class="btn btn-primary btn-lg" href="https://www.mckinsey.com/business-functions/risk/our-insights/covid-19-implications-for-business#" role="button">Learn more</a>
		</p>
	  </div>


	  <h2 style = "text-align: center;">New Stories from your network</h2>
	  
	<div class="col d-flex justify-content-center">
	  <div class="col-lg-4">

		  <div class="card mb-3">
			<h3 class="card-header">Watson Hawkins</h3>
			<div class="card-body">
			  <h5 class="card-title">Tips for Learning Programming</h5>
			  <h6 class="card-subtitle text-muted">23/04/2021</h6>
			</div>
			<svg xmlns="http://www.w3.org/2000/svg" class="d-block user-select-none" width="100%" height="200" aria-label="Placeholder: Image cap" focusable="false" role="img" preserveAspectRatio="xMidYMid slice" viewBox="0 0 318 180" style="font-size:1.125rem;text-anchor:middle">
			  <rect width="100%" height="100%" fill="#868e96"></rect>
			  <!-- <text x="50%" y="50%" fill="#dee2e6" dy=".3em">Image cap</text> -->
			  <img src = "Pictures/laptop cropped.png" alt = "Image Cap">
			</svg>
			<div class="card-body">
			  <p class="card-text">Have you ever wanted to build something but you had no idea what to do? Just as authors sometimes 
				  have "writers block" it's also true for developers. This list is intended to solve this issue once and for all! 
				  These applications are: </p>
			</div>
			<ul class="list-group list-group-flush">
			  <li class="list-group-item">great for improving your coding skills;</li>
			  <li class="list-group-item">great for experimenting with new technologies;</li>
			  <li class="list-group-item">great for adding to your portfolio to impress your next employer/client;</li>
			</ul>
			<div class="card-body">
			  <a href="#" class="card-link">Like</a>
			  <a href="#" class="card-link">Comment</a>
			</div>
			<div class="card-footer text-muted">
			  6 hours ago
			</div>
		  </div>
	</div>
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