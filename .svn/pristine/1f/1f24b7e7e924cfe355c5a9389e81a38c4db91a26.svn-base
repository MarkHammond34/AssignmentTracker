<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div class="alert alert-success" style="display: none;">
				<span class="glyphicon glyphicon-ok"></span>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th>Name</th>
						<th># of Assignments Due Today</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="course" items="${courses}">
						<c:choose>
							<c:when test="${course.assignmentCount eq 0}">
								<tr class="success">
									<td>${course.name}</td>
									<td>${course.assignmentCount}</td>
									<th><a>Edit</a></th>
									<th><a>Delete</a></th>
								</tr>
							</c:when>
							<c:when test="${course.assignmentCount eq 1}">
								<tr class="warning">
									<td>${course.name}</td>
									<td>${course.assignmentCount}</td>
									<th><a>Edit</a></th>
									<th><a>Delete</a></th>
								</tr>
							</c:when>
							<c:when test="${course.assignmentCount gt 1}">
								<tr class="danger">
									<td>${course.name}</td>
									<td>${course.assignmentCount}</td>
									<th><a data-toggle="modal"
										data-target="#createCourseModal">Edit</a></th>
									<th><a>Delete</a></th>
								</tr>
							</c:when>
						</c:choose>
						<%@ include file="edit-course-modal.jsp"%>
						<%@ include file="delete-course-modal.jsp"%>
						<%@ include file="course-assignments-modal.jsp"%>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>