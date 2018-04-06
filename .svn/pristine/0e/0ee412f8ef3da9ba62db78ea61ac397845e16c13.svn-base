<html>
<html>
<%@ include file="header.jsp"%>
</head>
<body>
<body>
	<%@ include file="navbar.jsp"%>
	<br>
	<div class="container">
		<br>
		<!-- <%@ include file="messages.jsp"%>  -->
		<div class="row">
			<br>
			<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4 toppad">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title" style="text-align: center;">{ Account
							Info }</h3>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-1 col-lg-1"></div>
							<div class=" col-md-10 col-lg-10">
								<a href="#" style="float: right;" data-toggle="modal"
									data-target="#editUserModal">Edit</a> <br>
								<table class="table table-user-information">
									<tbody>
										<tr>
											<td>First Name</td>
											<td>${user.firstName}</td>
										</tr>
										<tr>
											<td>Last Name:</td>
											<td>${user.lastName}</td>
										</tr>
										<tr>
											<td>Email</td>
											<td>${user.email}</td>
										</tr>
										<tr>
											<td>Phone Number</td>
											<td>${user.phoneNumber}</td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="col-md-1 col-lg-1"></div>
						</div>
					</div>
					<div class="panel-footer">
						<br>
					</div>
				</div>
			</div>
			<%@ include file="edit-user-profile-modal.jsp"%>

			<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8 toppad">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">This Weeks Assignments</h3>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class=" col-md-1 col-lg-1"></div>
							<div class=" col-md-10 col-lg-10 ">
								<table class="table table-user-information">
									<thead>
										<tr>
											<th>Course</th>
											<th>Assignment</th>
											<th>Due</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="assignment" items="${weeklyAssignments}">
											<tr>
												<td>${assignment.courseName}</td>
												<td>${assignment.name}</td>
												<td>${assignment.due}</td>
												<td><a href="" data-toggle="modal"
													data-target="#editAssignment${assignment.assignmentID}Modal">Edit</a></td>
											</tr>
											<%@ include file="assignment/edit-assignment-modal.jsp"%>
										</c:forEach>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class=" col-md-1 col-lg-1"></div>
						</div>
					</div>
					<div class="panel-footer">
						<br>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="assignment/create-assignment-modal.jsp"%>
	<%@ include file="course/create-course-modal.jsp"%>
</body>
</html>