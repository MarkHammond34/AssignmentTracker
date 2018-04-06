<div class="modal fade" id="editCourseModal" tabindex="-1" role="dialog"
	aria-labelledby="messageLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h3 class="modal-title" id="messageLabel">Edit ${course.name}</h3>
			</div>
			<form action="edit-course" method="post">
				<div class="modal-body">
					<div id="form-group">
						<label>Course Name </label><input class="form-control" type="text"
							name="name" value="${course.name}" />
					</div>
					<div id="form-group">
						<label>Course Description </label>
						<textarea class="form-control" name="description" rows="4"
							cols="50">${course.description}</textarea>

					</div>
				</div>
				<input type="hidden" value="${course.courseID}">
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary">Edit</button>
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
			</form>
		</div>
	</div>
</div>