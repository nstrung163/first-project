<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Book Management</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/plugins/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/style.css" />
	<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/asset/js/testValidate.js"></script> --%>
	<script type="text/javascript" src="${pageContext.request.contextPath}/asset/js/validation.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light">
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
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
			<h3 class="heading_title">Book Management</h3>
			<div class="heading_func">
				<c:if test="${book == null}">
					<form class="form-registration" action="book?action=insertBook" method="post"></form>
				</c:if>
				<c:if test="${book == null}"></c:if>
				<div class="heading_func-link"><a href="book">List All Books</a></div>
			</div>
		</div>
		
		<div class="container-fluid main">
			<span class="title-form">Add new book</span>
			<form class="form-registration" id="form-register" action="book?action=insertBook" method="post" onsubmit="return validate();">
				<div class="form__row bookId-error ">
					<label for="bookId" class="form__row-label">* ID Book: </label>
					<div class="form__row-input">
						<input class="res" id="bookId" type="text" name="bookId"   value="<c:out value='${books.bookId}'/>" placeholder="Enter book ID">
						<label class="lable-error">${error}</label>
					</div>
				</div>
				<div class="form__row">
					<label for="name" class="form__row-label">* Name: </label>
					<div class="form__row-input">
						<input class="res" id="name" type="text" name="name"  value="<c:out value='${books.name}'/>"  placeholder="Enter name book" >
					</div>
				</div>
				<div class="form__row">
					<label for="totalPage" class="form__row-label">* Total Page: </label>
					<div  class="form__row-input">
						<input class="res" id="totalPage" type="text"  name="totalPage"  value="<c:out value='${books.totalPage}'/>"   placeholder="Enter total page">
					</div>
				</div>	
				<div class="form__row">
					<label for="type" class="form__row-label">Type: </label>
					<div class="form__row-input">
						<input class="res" id="type" type="text" name="type"  value="<c:out value='${books.type}'/>" placeholder="Enter type of book">
					</div>
				</div>
				<div class="form__row">
					<label for="quantity" class="form__row-label">* Quantity: </label>
					<div class="form__row-input">
						<input class="res" id="quantity" type="text" name="quantity" value="<c:out value='${books.quantity}'/>"  placeholder="Enter quantity">
					</div>
				</div>
				<div class="btn-submit">
					<!-- <button class="btn-sub" type="submit" value="Submit">Submit</button> -->
					<input class="btn-sub" type="submit" value="Submit"/>
				</div>
			</form>
		</div> 		
	</div>
	<%-- <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.2/jquery.validate.min.js"></script> 
	 <script type="text/javascript" src="${pageContext.request.contextPath}/asset/js/validation.js"></script> 
	 <script type="text/javascript">
		function check() {
		    $('#form-register').validate({
		       rules: {
		           bookId: "required",
		           name: "required",
		           totalPage: "required",
		           quantity: "required"
		       },
		       messages: {
		    	   bookId: "BookID is required",
		           name: "Name book is required",
		           totalPage: "Total page is required",
		           quantity: "Quantity is required"
		       }
		    })
		 };
	</script> --%>
	<jsp:include page="/WEB-INF/header-footer/footer.jsp"></jsp:include>
</body>
</html>