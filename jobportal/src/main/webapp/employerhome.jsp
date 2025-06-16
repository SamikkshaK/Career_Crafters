<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="bootstrap_links.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employer Dashboard</title>
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
    <div class="card p-4 shadow-sm">
        <h2 class="text-primary">Welcome, ${loggedInUser.fullname}!</h2>
        <p class="lead">Post jobs and manage applicants with ease.</p>
        <a href="#" class="btn btn-outline-primary me-2">Post New Job</a>
        <a href="#" class="btn btn-outline-success">View Applicants</a>
        <a href="/" class="btn btn-danger mt-3">Logout</a>
    </div>
</div>

</body>
</html>
