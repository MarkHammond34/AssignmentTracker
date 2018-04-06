<div class="modal fade" id="deleteCourseModal" tabindex="-1"
	role="dialog" aria-labelledby="messageLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h3 class="modal-title" id="messageLabel">Are you sure?</h3>
			</div>
			<form action="delete-course" method="post">
				<input type="hidden" value="${course.couseID}">
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary">Delete</button>
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
			</form>
		</div>
	</div>
</div>