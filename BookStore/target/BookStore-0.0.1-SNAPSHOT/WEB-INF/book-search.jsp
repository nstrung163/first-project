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
	<jsp:include page="header.jsp"></jsp:include>
	<div class="header" align="center">
		<h1>Book Management</h1>
	</div>
	<div align="center">
		<c:if test="${book != null}">
			<form action="book?action=updateBook" method="post">
		</c:if>	
		<table border="1" cellpadding="5">
			<caption>
				<h2>
		        	<a href="book">List All Books</a> &nbsp;&nbsp;&nbsp;
		        	<a href="book?action=newBook">Add New Books</a>
		       	</h2>
				<h2>
					<c:if test="${book != null }">Edit book</c:if>
				</h2>
			</caption>
			
			<c:if test="${book != null}">
				<input type="hidden" name="id" value="<c:out value='book.bookId'/>">
			</c:if> 
			
			<tr>
				<th>ID: </th>
				<td>
					<label><c:out value='${book.bookId}'/></label>
					<input type="hidden" name="bookId" size="45" value="<c:out value='${book.bookId}'/>" required>
				</td>
			</tr>
			
			<tr>
				<th>Name: </th>
				<td>
					<input type="text" name="name" size="45" value="<c:out value='${book.name}'/>" required>
				</td>
			</tr>
			<tr>
				<th>Total Page: </th>
				<td>
					<input type="number" name="totalPage" size="45" value="<c:out value='${book.totalPage}'/>" required>
				</td>
			</tr>	
			<tr>
				<th>Type: </th>
				<td>
					<input type="text" name="type" size="45" value="<c:out value='${book.type}' />">
				</td> 
			</tr>
			<tr>
				<th>Quantity: </th>
				<td>
					<input type="number" name="quantity" size="45" value="<c:out value='${book.quantity}' />"required>
				</td> 
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Submit">
				</td>
			</tr>
		</table>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>