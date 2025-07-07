<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Books</title>
<link rel="stylesheet" type="text/css" href="/css/formstyle.css">
</head>
<body>
	<div id="whole">
        <h1>Book Store</h1>
        <form id="container" action="/add" method="post" >    
                <h3>Form for Adding Books</h3>
                <label class="label">Book Name:</label>
                <input class="input" type="text" name="book" required>
                <label class="label">Author:</label>
                <input class="input" type="text" name="author" required>
                <label class="label">Quantity:</label>
                <input class="input" type="number" name="quantity" required>
                <label class="label">Price:</label>
                <input class="input" type="number" name="price" required>
                <button id="button" type="submit">Add</button>
        </form>
        <nav id="navi">
			<a href="books">View List</a>
		</nav>
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