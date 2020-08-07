<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Book Management</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/plugins/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/style.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/asset/js/validation.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light">
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <!-- <a class="navbar-brand" href="home">BookStore</a> -->
	  <div class="collapse navbar-collapse" id="navbarTogglerDemo03">  
	    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
	      <li class="nav-item">
	        <a class="nav-link" href="student">Students</a>
	      </li>
	       <li class="nav-item">
	        <a class="nav-link active" href="book">Books</a>
	      </li>
	       <li class="nav-item">
	        <a class="nav-link" href="borrow">Borrows</a>
	      </li>
	    </ul>
		 <form action="book?action=searchBook" class="form-inline my-2 my-lg-0" method="post">
	 		<input class="form-control mr-sm-2" type="text" name="param" placeholder="Search book" >
	      	<button class="btn btn-outline-success my-2 my-sm-0 bg-green" type="submit">Search</button>
	    </form>  
	  </div>
	</nav>
	
	<div class="container-fluid">
		<div class="heading">
			<h3 class="heading_titel">Book Management</h3>
			<div class="heading_func">
				<c:if test="${book != null}">
					<form action="book?action=updateBook" method="post"></form>
				</c:if>
				<c:if test="${book != null }"></c:if>
				<div class="heading_func-link"><a href="book">List All Books</a></div>
			</div>
		</div>
		
		<div class="container-fluid main">
			<span class="title-form">Edit book</span>
			<form class="form-registration" id="formregister" action="book?action=updateBook" method="post">
				<c:if test="${book != null}">
					<input class="res" type="hidden" name="bookId" value="<c:out value='${book.bookId}'/>">
				</c:if> 
				<div class="form__row">
					<label class="form__row-label">ID Book: </label>
					<div class="form__row-input">
						<input class="res" type="hidden" name="bookId" value="<c:out value='${book.bookId}'/>">
						<c:out value='${book.bookId}'/>
						<label class="lable-error">${error}</label>
					</div>
				</div>
				<div class="form__row">
					<label class="form__row-label">Name: </label>
					<div class="form__row-input">
						<input class="res" type="text" name="name" value="<c:out value='${book.name}'/>" required>
					</div>
				</div>
				<div class="form__row">
					<label class="form__row-label">Total Page: </label>
					<div class="form__row-input">
						<input class="res" type="number" name="totalPage" value="<c:out value='${book.totalPage}'/>" required>
					</div>
				</div>
				<div class="form__row">
					<label class="form__row-label">Type: </label>
					<div class="form__row-input">
						<input class="res" type="text" name="type" value="<c:out value='${book.type}' />">
					</div>
				</div>
				<div class="form__row">
					<label class="form__row-label">Quantity: </label>
					<div class="form__row-input">
						<input class="res" type="number" name="quantity" size="45" value="<c:out value='${book.quantity}' />"required>
					</div>
				</div>
				<div class="btn-submit">
					<!-- <button class="btn-sub" type="submit">Submit</button> -->
					<input class="btn-sub" type="submit" value="Submit">
				</div>
			</form>
			
		</div>
	</div>
	<jsp:include page="/WEB-INF/header-footer/footer.jsp"></jsp:include>
</body>
</html>