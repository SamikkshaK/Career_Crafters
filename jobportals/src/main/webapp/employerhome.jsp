<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="bootstrap_links.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employer Dashboard</title>
    <style>
        body {
            background: url('images/bg image.webp') no-repeat center center;
            background-size: cover;
            height: 100vh;
            margin: 0;
        }
        .overlay {
            background-color: rgba(0, 0, 0, 0.6);
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .welcome-box {
            background-color: white;
            padding: 40px;
            border-radius: 10px;
            text-align: center;
            max-width: 600px;
            width: 90%;
            box-shadow: 0 5px 20px rgba(0,0,0,0.2);
        }
    
    </style>
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp">CareerCrafter</a>
        <div class="collapse navbar-collapse justify-content-end">
            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link" href="/">Logout</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container mt-5 text-center">
    <div class="card p-4 shadow-sm d-grid gap-3 col-6 mx-auto">
        <h2 class="text-primary">Welcome, ${loggedInUser.fullname}!</h2>
        <p class="lead">Post jobs and manage applicants with ease.</p>
        <a href="postJob.jsp" class="btn btn-outline-primary">Post New Job</a>
        <a href="manageJobs.jsp" class="btn btn-outline-info">Manage Job Listings</a>
        <a href="employerApplications.jsp" class="btn btn-outline-secondary">View Applications</a>
        <a href="updateCompanyProfile.jsp" class="btn btn-outline-dark">Update company Profile</a>
        <a href="resumeDatabase.jsp" class="btn btn-outline-success">Manage Resume Database</a>
        
    </div>
</div>

</body>
</html>
