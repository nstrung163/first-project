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
	</div>
	<div align="center">
		<c:if test="${book == null}">
			<form action="insertBook" method="post">
		</c:if>
	
		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<c:if test="${book == null }">Add new book</c:if>
				</h2>
			</caption>
			<tr>
				<th>ID Book: </th>
				<td>
					<input type="text" name="bookId" size="45" value="<c:out value='${books.bookId}'/>" >
				</td>
			</tr>
			
			<tr>
				<th>Name: </th>
				<td>
					<input type="text" name="name" size="45" value="<c:out value='${books.name}'/>" >
				</td>
			</tr>
			<tr>
				<th>Total Page: </th>
				<td>
					<input type="number" name="totalPage" size="45" value="<c:out value='${books.totalPage}'/>" >
				</td>
			</tr>	
			<tr>
				<th>Type: </th>
				<td>
					<input type="text" name="type" size="45" value="<c:out value='${books.type}'/>" >
				</td>
			</tr>
			<tr>
				<th>Quantity: </th>
				<td>
					<input type="number" name="quantity" size="45" value="<c:out value='${books.quantity}'/>" >
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Sign up">
				</td>
			</tr>
			</form>
		</table>
	</div>
</body>
</html>