<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="bootstrap_links.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register - CareerCrafter</title>
    <style>
        body { background-color: #f1f3f5; }
        .form-box {
            max-width: 600px;
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

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp">CareerCrafter</a>
        <div class="collapse navbar-collapse justify-content-end">
            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link active" href="register.jsp">Register</a></li>
                <li class="nav-item"><a class="nav-link" href="login.jsp">Login</a></li>
            </ul>
        </div>
    </div>
</nav>


<div class="form-box">
    <h3 class="text-center text-primary">Create Your CareerCrafter Account</h3>
    <form action="register" method="post">
        <div class="mb-3"><input type="text" name="fullname" class="form-control" placeholder="Full Name" required/></div>
        <div class="mb-3"><input type="email" name="email" class="form-control" placeholder="Email" required/></div>
        <div class="mb-3"><input type="password" name="password" class="form-control" placeholder="Password" required/></div>
        <div class="mb-3"><input type="tel" name="phone" class="form-control" placeholder="Phone" required/></div>
        <div class="mb-3"><textarea name="address" class="form-control" placeholder="Address" required></textarea></div>
        <div class="mb-3">
            <label>Gender:</label><br/>
            <input type="radio" name="gender" value="Male" required/> Male
            <input type="radio" name="gender" value="Female"/> Female
        </div>
        <div class="mb-3">
            <select name="role" class="form-select" required>
                <option value="">Select Role</option>
                <option value="USER">User</option>
                <option value="EMPLOYER">Employer</option>
            </select>
        </div>
        <div class="d-grid gap-2">
            <button type="submit" class="btn btn-primary">Register</button>
            <a href="login.jsp" class="btn btn-outline-secondary">Already have an account? Login</a>
        </div>
    </form>
</div>

</body>
</html>
