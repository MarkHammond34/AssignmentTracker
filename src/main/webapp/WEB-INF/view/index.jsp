<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<html>
<%@ include file="header.jsp"%>
<body>
	<%@ include file="navbar.jsp"%>
	<br>
	<div class="container">
		<br>
		<%@ include file="messages.jsp"%>
		<br>

		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8 heading">
				<h1>Assignments Due Today</h1>
			</div>
			<div class="col-md-2"></div>
		</div>

		<div class="row"></div>

		<%@ include file="assignment/assignment-feed.jsp"%>
	</div>

	<%@ include file="assignment/create-assignment-modal.jsp"%>
	<%@ include file="course/create-course-modal.jsp"%>

	<script src="resources/js/assignment.js"></script>
</body>
</html>