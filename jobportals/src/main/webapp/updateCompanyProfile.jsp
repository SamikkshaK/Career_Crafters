<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="bootstrap_links.jsp" %>
<html>
<head>
    <title>Update Company Profile</title>
    <style>
        body {
            background: url('images/bg image.webp') no-repeat center center;
            background-size: cover;
            height: 100vh;
            margin: 0;
        }
        .container {
            background-color: rgba(255, 255, 255, 0.95);
            padding: 30px;
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
    <h3 class="text-primary">Update Company Profile</h3>
    <form method="post" action="/updateCompany">
        <div class="mb-3">
            <label>Company Name</label>
            <input type="text" class="form-control" name="name" value="${company.name}">
        </div>
        <div class="mb-3">
            <label>Industry</label>
            <input type="text" class="form-control" name="industry" value="${company.industry}">
        </div>
        <div class="mb-3">
            <label>Description</label>
            <textarea class="form-control" name="description">${company.description}</textarea>
        </div>
        <div class="mb-3">
            <label>Website</label>
            <input type="text" class="form-control" name="website" value="${company.website}">
        </div>
        <button type="submit" class="btn btn-success">Update</button>
    </form>
</div>
</body>
</html>