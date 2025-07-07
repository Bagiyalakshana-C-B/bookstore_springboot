<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Book</title>
<link rel="stylesheet" type="text/css" href="css/formstyle.css">
</head>
<body>
	<div id="whole">
		<h1>Book Store</h1>
		<%
			String action = (String) request.getAttribute("action");
			if("sell".equals(action)){
		%>
				<form id="container" action="/sell" method="post">
					<h3>Sell Book(s)</h3>
					<label class="label">Book Id:</label>
					<input class="input" type="number" name="id">
					<label class="label">Quantity:</label>
					<input class="input" type="number" name="quantity">
					<button id="button" type ="submit">Sell</button>
				</form>
		<%
			}else if ("buy".equals(action)) { 
		%>	
				<form id="container" action="/buy" method="post">
					<h3>Buy Book(s)</h3>
					<label class="label">Book Id:</label>
					<input class="input" type="number" name="id">
					<label class="label">Quantity:</label>
					<input class="input" type="number" name="quantity">
					<button id="button" type ="submit">Buy</button>
				</form>
		<%} %>
		<nav id="navi">
			<a href="books">View List</a>
		</nav>
	</div>
	<%
           String msg = (String) request.getAttribute("msg");
           if (msg != null) {
     %>
            <script>alert("<%= msg %>");</script>
      <%
            }
      %>
</body>
</html>