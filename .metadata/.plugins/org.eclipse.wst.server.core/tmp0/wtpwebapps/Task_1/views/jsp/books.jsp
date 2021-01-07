<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ces.model.BookModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="views/css/books.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="text-align: center; padding: 3rem 10rem">
	<h1>Books</h1>
	<div class="books__actions">
		<button>
			<a href="views/jsp/add.jsp">Create new</a>
		</button>
	</div>
	<%
		List<BookModel> books = (ArrayList)request.getAttribute("books");
		Iterator<BookModel> iterator = books.iterator();
		while(iterator.hasNext()) {
			BookModel book = iterator.next();
	%>

	<form style="border: 1px solid black; width: 30%; align-content: center; display: inline-block; margin: 1rem">
	<h1> <%= book.getName() %> </h1>
	<h3> <%= book.getAuthor() %> </h3>
	<button>
		<a href="<%= request.getContextPath() %>/Book?id=<%= book.getId() %>&type=delete ">Delete</a>
	</button>
	<button>
		<a href="<%= request.getContextPath() %>/Book?id=<%= book.getId() %>&type=edit ">Edit</a>
	</button>
	</form>

<% } %>

</body>
</html>