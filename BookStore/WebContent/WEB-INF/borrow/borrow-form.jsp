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
	<jsp:include page="/WEB-INF/header-footer/header.jsp"></jsp:include>
	<div class="header" align="center">
		<h1>Borrow Management</h1>
	</div>
	<div align="center">
		<c:if test="${borrow != null}">
			<form action="borrow?action=updateBorrow" method="post">
		</c:if>
	
		<c:if test="${borrow == null}">
			<form action="borrow?action=insertBorrow" method="post">
		</c:if>
	
		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<c:if test="${borrow != null }">Edit borrow</c:if>
					<c:if test="${borrow == null }">Add new borrow</c:if>
				</h2>
			</caption>
			<c:if test="${borrow != null }">
				<input type="hidden" name="borrowId" value="<c:out value='${borrow.borrowId }'/>">
			</c:if>
			<tr>
				<th>StudentID: </th>
				<td>
					<input type="text" name="studentId" size="45" value="<c:out value='${borrow.studentId}'/>" required >
				</td>
			</tr>
			
			<tr>
				<th>BookID:</th>
				<td>
					<input type="text" name="bookId" size="45" value="<c:out value='${borrow.bookId}'/>" required >
				</td>
			</tr>
			<tr>
				<th>Quantity: </th>
				<td>
					<input type="number" name="quantity" size="45" value="<c:out value='${borrow.quantity}'/>">
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
	<jsp:include page="/WEB-INF/header-footer/footer.jsp"></jsp:include>
</body>
</html>