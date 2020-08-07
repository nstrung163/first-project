<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Management</title>
<link href="css/book-list.css" rel="stylesheet" type="text/css" /> 

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="header" align="center">
		<h1>Book Management</h1>
		<h3>
			<a href="book?action=newBook" >Add new book</a>
		</h3>
		<div class="search">
        	<input type="text" name="bookId" >
        	<a href="book?action=searchBook">Search</a>
        </div>
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
						<c:if test="${book.type eq null ||book.type eq ''}">
							<c:out value="Null"></c:out>
						</c:if>
						<c:out value="${book.type}"></c:out>
					</td>
					<td><c:out value="${book.quantity}"/></td>
					<td>
						<a href="book?action=editBook&bookId=<c:out value='${book.bookId}'/>">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="book?action=deleteBook&bookId=<c:out value='${book.bookId}'/>">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>