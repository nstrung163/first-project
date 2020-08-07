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
	<jsp:include page="header.jsp"></jsp:include>
	<div class="header" align="center">
		<h1>Student Management</h1>
		<h3>
			<a href="student?action=newStudent">Add new student</a>
		</h3>
	</div>
	<div class="form" align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>List of students</h2>
			</caption>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Age</th>
				<th>Gender</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="student" items="${listStudent}">
				<tr>
					<td><c:out value="${student.studentId}"/></td>
					<td><c:out value="${student.name}"/></td>
					<td><c:out value="${student.age}"/></td>
					<td>
						<c:if test="${student.gender==true}">
							<c:out value="Male"></c:out>
						</c:if> 
						<c:if test="${student.gender==false}">
							<c:out value="Female"></c:out>
						</c:if>
					</td>
					<td>
						<a href="student?action=editStudent&studentId=<c:out value='${student.studentId}'/>">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="student?action=deleteStudent&studentId=<c:out value='${student.studentId}'/>">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>