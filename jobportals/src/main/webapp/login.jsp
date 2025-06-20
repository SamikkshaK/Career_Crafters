<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="bootstrap_links.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login - CareerCrafter</title>
    <style>
        body {
            background-color: #f8f9fa;
        }
        .form-box {
            max-width: 500px;
            margin: 60px auto;
            padding: 30px;
            background: #fff;
            border-radius: 10px;
            box-shadow: 0 6px 20px rgba(0,0,0,0.1);
        }
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

<!-- Navbar directly inside this file -->
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp">CareerCrafter</a>
        <div class="collapse navbar-collapse justify-content-end">
            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link " href="register.jsp">Register</a></li>
                <li class="nav-item"><a class="nav-link active" href="login.jsp">Login</a></li>
            </ul>
        </div>
    </div>
</nav>
<!-- Page content -->
<div class="form-box">
    <h3 class="text-center text-primary">Login to CareerCrafter</h3>
    <form action="login" method="post">
        <div class="mb-3">
            <label>Email</label>
            <input type="email" name="email" class="form-control" required/>
        </div>
        <div class="mb-3">
            <label>Password</label>
            <input type="password" name="password" class="form-control" required/>
        </div>
        <div class="d-grid gap-2">
            <button type="submit" class="btn btn-success">Login</button>
            <a href="register.jsp" class="btn btn-outline-primary">Don't have an account? Register</a>
        </div>
    </form>
</div>

</body>
</html>
