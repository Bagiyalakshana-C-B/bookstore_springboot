<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="/css/formstyle.css">
</head>
<body>
	<div id="whole">
        <h1>Book Store</h1>
        <%
			String action = (String) request.getAttribute("action");
			if("login".equals(action)){
		%>
		        <form id="container" action="/login" method="post" >    
		                <h3>Login</h3>
		                <label class="label">User Name:</label>
		                <input class="input" type="text" name="username" required>
		                <label class="label">Password:</label>
		                <input class="input" type="password"  name="password" required>
		                <button id="button" type="submit">Login</button>
		        </form>
		        <nav id="navi">
					<a href="signup">Signup</a>
				</nav>
        <%
			}else if ("signup".equals(action)) { 
		%>	
				<form id="container" action="/signup" method="post">
					<h3>Signup</h3>
					<label class="label">User Name:</label>
					<input class="input" type="text" name="username" required>
					<label class="label">Password:</label>
					<input class="input" type="password" name="password">
					<button id="button" type ="submit">Signup</button>
				</form>
				<nav id="navi">
					<a href="login">Login</a>
				</nav>
		<%} %>
    </div>
    <%
	    String msg = (String) request.getAttribute("msg");
	    if (msg != null) {
	%>
	    <script>
	        alert("<%= msg %>");
	    </script>
	<%
	    }
	%>
</body>
</html>