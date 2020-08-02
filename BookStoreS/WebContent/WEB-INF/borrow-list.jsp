<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Borrow Management</title>
</head>
<body>
	<div class="header" align="center">
		<h1>Borrow Management</h1>
		<h3>
			<a href="student">Students</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="book">Books</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<!-- <input type="text" size="20" placeholder="Search">
			<a href="borrow?action=searchBorrow" >Search borrow</a>&nbsp;&nbsp;&nbsp;&nbsp; -->
			<a href="borrow?action=newBorrow" >Add new borrow</a>
		</h3>
		<h3></h3>
	</div>
	<div class="form" align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>List of borrows</h2>
			</caption>
			<tr>
				<th>STT</th>
				<th>StudentID</th>
				<th>BookID</th>
				<th>Borrow date</th>
				<th>Quantity</th>
				<th>Status</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="borrow" items="${listBorrow}">
				<tr>
					<td><c:out value="${borrow.borrowId}"/></td>
					<td><c:out value="${borrow.studentId}"/></td>
					<td><c:out value="${borrow.bookId}"/></td>
					<td><c:out value="${borrow.borrowDate }"  /></td>
					<td><c:out value="${borrow.quantity}"/></td>
					<td><a href="borrow?action=editBook&borrowId=<c:out value='${book.bookId}'/>">Borrowing</a></td>
					<td>
						<a href="borrow?action=editBook&borrowId=<c:out value='${book.bookId}'/>">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="borrow?action=deleteBorrow&borrowId=<c:out value='${book.bookId}'/>">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>