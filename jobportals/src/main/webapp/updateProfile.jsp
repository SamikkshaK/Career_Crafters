<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="bootstrap_links.jsp" %>
<html>
<head>
    <title>Update Profile</title>
    <style>
        body {
            background: url('images/bg image.webp') no-repeat center center;
            background-size: cover;
            height: 100vh;
            margin: 0;
        }
        .container {
            background-color: rgba(255, 255, 255, 0.95);
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
    <h3 class="text-primary">Update Your Profile</h3>
    <form method="post" action="/updateProfile">
        <div class="mb-3">
            <label>Email</label>
            <input type="text" class="form-control" name="email" value="${loggedInUser.email}" readonly>
        </div>
        <div class="mb-3">
            <label>Full Name</label>
            <input type="text" class="form-control" name="fullname" value="${loggedInUser.fullname}">
        </div>
        <div class="mb-3">
            <label>Phone</label>
            <input type="text" class="form-control" name="phone" value="${loggedInUser.phone}">
        </div>
        <div class="mb-3">
            <label>Address</label>
            <input type="text" class="form-control" name="address" value="${loggedInUser.address}">
        </div>
        <button type="submit" class="btn btn-success">Update</button>
    </form>
</div>
</body>
</html>