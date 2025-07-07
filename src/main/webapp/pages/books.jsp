<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.bootbs.bookstore.Model.BookStoreModel"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%List<BookStoreModel> books = (List<BookStoreModel>) request.getAttribute("books"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Books</title>
<link rel="stylesheet" type="text/css" href="/css/booksstyle.css">
</head>
<body>
	<div id="whole">
		<nav id="navi">
			<a href="add">Add Book</a>
			<a href="delete">Delete a Book</a>
			<a href="sell">Sell</a>
			<a href="buy">Buy</a>
			<a href="logout">Logout</a>
		</nav>
		
		<h1>Book Store</h1>
		<h3>Available Books</h3><br>
		<table id="table">
			<thead>
				<tr>
					<th>Id</th>
					<th>Book</th>
					<th>Author</th>
					<th>Stock</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<% for(BookStoreModel book:books){%>
				    <tr>
				    	<td><%=book.getId() %></td>
				        <td><%=book.getBook() %></td>
				        <td><%=book.getAuthor() %></td>
				        <td><%=book.getQuantity() %></td>
				        <td><%=book.getPrice() %></td>
				    </tr>
				<%}%>
			</tbody>
		</table>
	</div>
</body>
</html>