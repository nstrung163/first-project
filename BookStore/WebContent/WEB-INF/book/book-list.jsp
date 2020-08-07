<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Management</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/plugins/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/style.css" />
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light">
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<!-- <a class="navbar-brand" href="home">BookStore</a> -->
	<div class="collapse navbar-collapse" id="navbarTogglerDemo03">
		<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
			<li class="nav-item"><a class="nav-link" href="student">Students</a>
			</li>
			<li class="nav-item"><a class="nav-link active" href="book">Books</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="borrow">Borrows</a>
			</li>
		</ul>
		<form action="book?action=searchBook" class="form-inline my-2 my-lg-0"
			method="post">
			<input class="form-control mr-sm-2" type="text" name="param" placeholder="Search book">
			<button class="btn btn-outline-success my-2 my-sm-0 bg-green"
				type="submit">Search</button>
		</form>
	</div>
	</nav>
	<div class="container-fluid">
		<div class="heading">
			<h3 class="heading_titel">Book Management</h3>
			<div class="heading_func">
				<div class="heading_func-link">
					<a href="book?action=newBook">Add new book</a>
				</div>
			</div>
		</div>
		<div class="container-fluid main">
			<span class="title-form">List of books</span>
			<table cellpadding="5" cellspacing="5">
				<tr>
					<th class="label-th">BookID</th>
					<th class="label-th">Name</th>
					<th class="label-th">TotalPage</th>
					<th class="label-th">Type</th>
					<th class="label-th">Quantity</th>
					<th class="label-th">Actions</th>
				</tr>
				<c:forEach var="book" items="${listBook}">
					<tr class="feilds-tr">
						<td class="feilds-td"><c:out value="${book.bookId}" /></td>
						<td class="feilds-td"><c:out value="${book.name}" /></td>
						<td class="feilds-td"><c:out value="${book.totalPage}" /></td>
						<td class="feilds-td"><c:if
								test="${book.type eq null ||book.type eq ''}">
								<c:out value="Null"></c:out>
							</c:if> <c:out value="${book.type}"></c:out></td>
						<td class="feilds-td"><c:out value="${book.quantity}" /></td>
						<td class="feilds-td"><a
							href="book?action=editBook&bookId=<c:out value='${book.bookId}'/>">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="book?action=deleteBook&bookId=<c:out value='${book.bookId}'/>">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<jsp:include page="/WEB-INF/header-footer/footer.jsp"></jsp:include>
</body>
</html>