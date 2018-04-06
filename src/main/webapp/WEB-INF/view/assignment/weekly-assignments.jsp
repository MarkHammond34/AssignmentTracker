<!DOCTYPE html>
<html>
<%@ include file="../header.jsp"%>
</head>
<body>
<body>
	<%@ include file="../navbar.jsp"%>
	<br>
	<div class="container">
		<br>
		<!-- 
		<%@ include file="../messages.jsp"%>
		 -->
		<div class="row">
			<h2 class="heading">Assignments Due This Week</h2>
			<br>
			<c:choose>
				<c:when test="${dueSunday gt 1}">
					<div class="panel panel-danger col-md-3">
						<div class="panel-heading day-header">Sunday</div>
						<div id="collapse-body-sunday" class="panel-body">
							<table class="table">
								<thead>
									<tr>
										<th>Name</th>
										<th>Due</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="assignment" items="${sundayList}">
										<tr>
											<td>${assignment.name}</td>
											<td>${assignment.due}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</c:when>
				<c:when test="${dueSunday eq 1}">
					<div class="panel panel-warning col-md-3">
						<div class="panel-heading day-header">Sunday</div>
						<div id="collapse-body-sunday" class="panel-body">
							<table class="table">
								<thead>
									<tr>
										<th>Name</th>
										<th>Due</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="assignment" items="${sundayList}">
										<tr>
											<td>${assignment.name}</td>
											<td>${assignment.due}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="panel panel-success col-md-3">
						<div class="panel-heading day-header">Sunday</div>
						<div id="collapse-body-sunday" class="panel-body"></div>
					</div>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${dueMonday gt 1}">
					<div class="panel panel-danger col-md-3">
						<div class="panel-heading day-header">Monday</div>
						<div class="panel-body">
							<table class="table">
								<thead>
									<tr>
										<th>Name</th>
										<th>Due</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="assignment" items="${mondayList}">
										<tr>
											<td>${assignment.name}</td>
											<td>${assignment.due}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</c:when>
				<c:when test="${dueMonday eq 1}">
					<div class="panel panel-warning col-md-3">
						<div class="panel-heading day-header">Monday</div>
						<div class="panel-body">
							<table class="table">
								<thead>
									<tr>
										<th>Name</th>
										<th>Due</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="assignment" items="${mondayList}">
										<tr>
											<td>${assignment.name}</td>
											<td>${assignment.due}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="panel panel-success col-md-3">
						<div class="panel-heading day-header">Monday</div>
						<div class="panel-body"></div>
					</div>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${dueTuesday gt 1}">
					<div class="panel panel-danger col-md-3">
						<div class="panel-heading day-header">Tuesday</div>
						<div class="panel-body">
							<table class="table">
								<thead>
									<tr>
										<th>Name</th>
										<th>Due</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="assignment" items="${tuesdayList}">
										<tr>
											<td>${assignment.name}</td>
											<td>${assignment.due}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</c:when>
				<c:when test="${dueTuesday eq 1}">
					<div class="panel panel-warning col-md-3">
						<div class="panel-heading day-header">Tuesday</div>
						<div class="panel-body">
							<table class="table">
								<thead>
									<tr>
										<th>Name</th>
										<th>Due</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="assignment" items="${tuesdayList}">
										<tr>
											<td>${assignment.name}</td>
											<td>${assignment.due}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="panel panel-success col-md-3">
						<div class="panel-heading day-header">Tuesday</div>
						<div class="panel-body"></div>
					</div>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${dueWednesday gt 1}">
					<div class="panel panel-danger col-md-3">
						<div class="panel-heading day-header">Wednesday</div>
						<div class="panel-body">
							<table class="table">
								<thead>
									<tr>
										<th>Name</th>
										<th>Due</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="assignment" items="${wednesdayList}">
										<tr>
											<td>${assignment.name}</td>
											<td>${assignment.due}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</c:when>
				<c:when test="${dueWednesday eq 1}">
					<div class="panel panel-warning col-md-3">
						<div class="panel-heading day-header">Wednesday</div>
						<div class="panel-body">
							<table class="table">
								<thead>
									<tr>
										<th>Name</th>
										<th>Due</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<c:forEach var="assignment" items="${wednesdayList}">
											<td>${assignment.name}</td>
											<td>${assignment.due}</td>
										</c:forEach>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="panel panel-success col-md-3">
						<div class="panel-heading day-header">Wednesday</div>
						<div class="panel-body"></div>
					</div>
				</c:otherwise>
			</c:choose>

		</div>
		<div class="row" style="margin-top: 8%;">
			<div class="col-md-1"></div>
			<c:choose>
				<c:when test="${dueThursday gt 1}">
					<div class="panel panel-danger col-md-3">
						<div class="panel-heading day-header">Thursday</div>
						<div class="panel-body">
							<table class="table">
								<thead>
									<tr>
										<th>Name</th>
										<th>Due</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="assignment" items="${thursdayList}">
										<tr>
											<td>${assignment.name}</td>
											<td>${assignment.due}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</c:when>


				<c:when test="${dueThursday eq 1}">
					<div class="panel panel-warning col-md-3">
						<div class="panel-heading day-header">Thursday</div>
						<div class="panel-body">
							<table class="table">
								<thead>
									<tr>
										<th>Name</th>
										<th>Due</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="assignment" items="${thursdayList}">
										<tr>
											<td>${assignment.name}</td>
											<td>${assignment.due}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="panel panel-success col-md-3">
						<div class="panel-heading day-header">Thursday</div>
						<div class="panel-body"></div>
					</div>
				</c:otherwise>
			</c:choose>


			<c:choose>
				<c:when test="${dueFriday gt 1}">
					<div class="panel panel-danger col-md-3">
						<div class="panel-heading day-header">Friday</div>
						<div class="panel-body">
							<table class="table">
								<thead>
									<tr>
										<th>Name</th>
										<th>Due</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="assignment" items="${fridayList}">
										<tr>
											<td>${assignment.name}</td>
											<td>${assignment.due}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</c:when>


				<c:when test="${dueFriday eq 1}">
					<div class="panel panel-warning col-md-3">
						<div class="panel-heading day-header">Friday</div>
						<div class="panel-body">
							<table class="table">
								<thead>
									<tr>
										<th>Name</th>
										<th>Due</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="assignment" items="${fridayList}">
										<tr>
											<td>${assignment.name}</td>
											<td>${assignment.due}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="panel panel-success col-md-3">
						<div class="panel-heading day-header">Friday</div>
						<div class="panel-body"></div>
					</div>
				</c:otherwise>
			</c:choose>


			<c:choose>
				<c:when test="${dueSaturday gt 1}">
					<div class="panel panel-danger col-md-3">
						<div class="panel-heading day-header">Saturday</div>
						<div class="panel-body">
							<table class="table">
								<thead>
									<tr>
										<th>Name</th>
										<th>Due</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="assignment" items="${saturdayList}">
										<tr>
											<td>${assignment.name}</td>
											<td>${assignment.due}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</c:when>


				<c:when test="${dueSaturday eq 1}">
					<div class="panel panel-warning col-md-3">
						<div class="panel-heading day-header">Saturday</div>
						<div class="panel-body">
							<table class="table">
								<thead>
									<tr>
										<th>Name</th>
										<th>Due</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="assignment" items="${saturdayList}">
										<tr>
											<td>${assignment.name}</td>
											<td>${assignment.due}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="panel panel-success col-md-3">
						<div class="panel-heading day-header">Saturday</div>
						<div class="panel-body"></div>
					</div>
				</c:otherwise>
			</c:choose>

		</div>

		<%@ include file="../assignment/create-assignment-modal.jsp"%>
		<%@ include file="../course/create-course-modal.jsp"%>
	</div>
</body>
</html>