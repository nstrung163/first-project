<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Management</title>
</head>
<body>
	<jsp:include page="/WEB-INF/header-footer/header.jsp"></jsp:include>
	<div class="header" align="center">
		<h1>Student Management</h1>
	</div>
	<div align="center">
		<c:if test="${student == null}">
			<form action="student?action=insertStudent" method="post">
		</c:if>
	
		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<c:if test="${student == null }">Add new student</c:if>
				</h2>
			</caption>
			<tr>
				<th>ID: </th>
				<td>
					<input type="text" name="studentId" size="45" value="<c:out value='${student.studentId}'/>" >
				</td>
			</tr>
			
			<tr>
				<th>Name: </th>
				<td>
					<input type="text" name="name" size="45" value="<c:out value='${student.name}'/>" >
				</td>
			</tr>
			<tr>
				<th>Age: </th>
				<td>
					<input type="number" name="age" size="45" value="<c:out value='${student.age}'/>" >
				</td>
			</tr>	
			<tr>
				<th>Gender: </th>
				<td>
					<input type="radio" name="gender" value="true">Male<br>
					<input type="radio" name="gender" value="false">Female<br>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Submit">
				</td>
			</tr>
			</form>
		</table>
	</div>
	<jsp:include page="/WEB-INF/header-footer/footer.jsp"></jsp:include>
</body>
</html>