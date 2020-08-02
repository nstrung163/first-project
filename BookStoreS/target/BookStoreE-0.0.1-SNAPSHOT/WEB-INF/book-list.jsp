<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Management</title>
</head>
<body>
	<div class="header" align="center">
		<h1>Book Management</h1>
		<h3>
			<a href="BookController?action=newBook">Add new book</a>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="StudentController">Students</a>
		</h3>
	</div>
	<div class="form" align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>List of books</h2>
			</caption>
			<tr>
				<th>BookID</th>
				<th>Name</th>
				<th>TotalPage</th>
				<th>Type</th>
				<th>Quantity</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="book" items="${listBook}">
				<tr>
					<td><c:out value="${book.bookId}"/></td>
					<td><c:out value="${book.name}"/></td>
					<td><c:out value="${book.totalPage}"/></td>
					<td>
						<c:if test="${book.type == null}">
							<c:out value="null"></c:out>
						</c:if>
						<c:out value="${book.type}"></c:out>
					</td>
					<td><c:out value="${book.quantity}"/></td>
					<td>
						<a href="editBook?bookId=<c:out value='${book.bookId}'/>">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="deleteBook?bookId=<c:out value='${book.bookId}'/>">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>