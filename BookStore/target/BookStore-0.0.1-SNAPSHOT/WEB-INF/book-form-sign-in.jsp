<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Management</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/book-sign-up.css" />
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="header" align="center">
		<h1>Book Management</h1>
	</div>
	<div align="center">
		<c:if test="${book == null}">
			<form action="book?action=insertBook" method="post">
		</c:if>
	
		<table border="0" cellpadding="5">
			<caption>
				<h2>
					<a href="book">List All Books</a> &nbsp;&nbsp;&nbsp;
					<c:if test="${book == null }">Add new book</c:if>
				</h2>
			</caption>
			<tr>
				<th>ID Book: </th>
				<td>
					<input type="text" autocapitalize="none" name="bookId" size="45" value="<c:out value='${books.bookId}'/>" required placeholder="Enter book ID">
					<label style="color:red;">${error}</label>
				</td>
			</tr>
			
			<tr>
				<th>Name: </th>
				<td>
					<input type="text" name="name" size="45" value="<c:out value='${books.name}'/>" required placeholder="Enter name book" >
				</td>
			</tr>
			<tr>
				<th>Total Page: </th>
				<td>
					<input type="number" min="1" name="totalPage" size="45" value="<c:out value='${books.totalPage}'/>" required  placeholder="Enter total page">
				</td>
			</tr>	
			<tr>
				<th>Type: </th>
				<td>
					<input type="text" name="type" size="45" value="<c:out value='${books.type}'/>" placeholder="Enter type of book">
				</td>
			</tr>
			<tr>
				<th>Quantity: </th>
				<td>
					<input type="number" min="1" name="quantity" size="45" value="<c:out value='${books.quantity}'/>" required placeholder="Enter quantity">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Sign up">
				</td>
			</tr>
			</form>
		</table>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>