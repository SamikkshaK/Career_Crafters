<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="bootstrap_links.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>CareerCrafter - Home</title>
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
                <li class="nav-item"><a class="nav-link" href="register.jsp">Register</a></li>
                <li class="nav-item"><a class="nav-link" href="login.jsp">Login</a></li>
            </ul>
        </div>
    </div>
</nav>

<!-- Banner -->
<div class="overlay">
    <div class="welcome-box">
        <h1 class="text-primary">Welcome to CareerCrafter</h1>
        <p class="lead">Connecting job seekers and employers on one platform.</p>
        <a href="register.jsp" class="btn btn-success me-3">Get Started</a>
    </div>
</div>

</body>
</html>
