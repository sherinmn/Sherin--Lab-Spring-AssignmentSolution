<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">


<title>Save Student</title>
</head>
<body>
	<div class="container">
		<h2 style="text-align: center">Student Debate Registration</h2>
		<hr>
		<p class="h4 mb-4">Save Student</p>
		<form action="/spring-boot-student/students/save"
			method="POST">
			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${Student.id}" />

			<div class="form-inline">
				<input type="text" name="name"
					value="${Student.name}"
					class="form-control mb-4 col-4" placeholder="Full Name" required />
			</div>
			<div class="form-inline">
				<input type="text" name="department"
					value="${Student.department}"
					class="form-control mb-4 col-4" placeholder="Department" required />
			</div>
			<div class="form-inline">
				<input type="text" name="country"
					value="${Student.country}"
					class="form-control mb-4 col-4" placeholder="Country" required />
			</div>
			<button type="submit" class="btn btn-info col-2">Save</button>
		</form>
		<hr>
		<a href="/spring-boot-student/students/list">Back
			to Student List</a>
	</div>
</body>

</html>