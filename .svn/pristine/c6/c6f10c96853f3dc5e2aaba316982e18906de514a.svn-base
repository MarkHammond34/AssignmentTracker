<div class="modal fade" id="#editCourseModal" tabindex="-1"
	role="dialog" aria-labelledby="messageLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h3 class="modal-title" id="messageLabel">Create A New
					Assignment</h3>
			</div>
			<form action="create-assignment" method="POST">
				<div class="modal-body">
					<div id="form-group">
						<label>Course </label><select required name="course"
							class="form-control">
							<c:forEach var="course" items="${courses}">
								<option value="${course.courseID}">${course.name}</option>
							</c:forEach>
						</select>

					</div>
					<div id="form-group">
						<label>Assignment Name </label><input class="form-control"
							type="text" name="name" required />
					</div>
					<div id="form-group">
						<label>Description</label>
						<textarea class="form-control" name="courseDesc" rows="4"
							cols="50">Short Description (Not Requred)</textarea>

					</div>
					<div id="form-group">
						<label>Due (Date and Time)</label> <input class="form-control"
							type="datetime-local" name="due" required />
					</div>
					<div id="form-group">
						<label>Difficulty (Scale of 1 to 10)</label> <input
							class="form-control" type="number" name="difficulty" min="1"
							max="10">
					</div>
					<div id="form-group">
						<label>Approximate Time Required</label> <select required
							name="timeRequired" class="form-control">
							<option value="15">15 minutes</option>
							<option value="30">30 minutes</option>
							<option value="45">45 minutes</option>
							<option value="60">1 hour</option>
							<option value="90">1 hour 30 minutes</option>
							<option value="120">2 hours</option>
							<option value="150">2 hours 30 minutes</option>
							<option value="180">3 hours</option>
							<option value="210">3 hours 30 minutes</option>
							<option value="240">4 hours</option>
							<option value="270">4 hours 30 minutes</option>
							<option value="300">5 hours+</option>
						</select>
					</div>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary">Create</button>
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
			</form>
		</div>
	</div>
</div>