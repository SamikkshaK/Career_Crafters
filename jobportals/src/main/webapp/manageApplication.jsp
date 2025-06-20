<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="bootstrap_links.jsp" %>
<html>
<head>
    <title>Manage Applications</title>
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
<div class="container">
    <h2 class="text-primary">Your Applications</h2>
    <table class="table table-striped">
        <thead class="table-dark">
        <tr>
            <th>Job Title</th>
            <th>Applied Date</th>
            <th>Status</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="app" items="${applications}">
            <tr>
                <td>${app.job.title}</td>
                <td>${app.appliedDate}</td>
                <td>${app.status}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
