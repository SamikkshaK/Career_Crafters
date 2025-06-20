<!-- postJob.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="bootstrap_links.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Post New Job</title>
    <style>
        body {
            background: url('images/bg image.webp') no-repeat center center;
            background-size: cover;
            height: 100vh;
            margin: 0;
        }
        .container {
            background-color: rgba(255,255,255,0.95);
            padding: 40px;
            border-radius: 10px;
            margin-top: 50px;
        }
    </style>
</head>
<body>
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
<div class="container col-md-6">
    <h3 class="text-primary">Post a New Job</h3>
    <form action="/postJob" method="post">
        <div class="mb-3">
            <label>Title</label>
            <input type="text" name="title" class="form-control" required>
        </div>
        <div class="mb-3">
            <label>Description</label>
            <textarea name="description" class="form-control" required></textarea>
        </div>
        <div class="mb-3">
            <label>Location</label>
            <input type="text" name="location" class="form-control">
        </div>
        <div class="mb-3">
            <label>Skills</label>
            <input type="text" name="skills" class="form-control">
        </div>
        <div class="mb-3">
            <label>Salary</label>
            <input type="text" name="salary" class="form-control">
        </div>
        <div class="mb-3">
            <label>Job Type</label>
            <select name="jobType" class="form-control">
                <option value="Full Time">Full Time</option>
                <option value="Part Time">Part Time</option>
                <option value="Internship">Internship</option>
            </select>
        </div>
        <button type="submit" class="btn btn-success">Post Job</button>
    </form>
</div>
</body>
</html>