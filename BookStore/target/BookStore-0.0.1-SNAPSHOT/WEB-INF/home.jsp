<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<h2>Home page</h2>
	<h3>Welcome to book store management application</h3>
	<strong>Book store manegement include the following functions: </strong>
	<ul>
		<li>Book management</li>
		<li>Student manegement</li>
		<li>Borrow management</li>
		<li>Search book,student,borrow</li>
	</ul>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>