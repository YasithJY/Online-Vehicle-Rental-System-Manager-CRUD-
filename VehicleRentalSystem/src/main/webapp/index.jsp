<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manager Login</title>
 <link rel="stylesheet" href="index.css">
</head>
<body>

<div class="login-box">
  <h1>Manager Login</h1>
  <form id="login-form" method="post" action="login">
    <div class="user-box">
      <input type="text" id="username" name="username"required>
      <label>Username</label>
    </div>
    <div class="user-box">
      <input type="password" id="password" name="password"required>
      <label>Password</label>
    </div>
    <div class="submit-btn"><button class="button"><span class="button-content">LOGIN</span></button></div>
  </form>
</div>
<script>
  function validateForm() {
      const username = document.getElementById("username").value;
      const password = document.getElementById("password").value;

      if(!username.includes("@")) {
          alert("Username must contain '@' symbol!");
          return false;
      }

      return true;
  }
</script>

</body>
</html>