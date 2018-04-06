<div class="modal fade" id="editUserModal" tabindex="-1" role="dialog"
	aria-labelledby="messageLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h3 class="modal-title" id="messageLabel">Edit Account
					Information</h3>
			</div>
			<form method="POST" action="edit-user">
				<div class="modal-body">
					<div class="form-group">
						<label for="name" class="cols-sm-2 control-label">Your
							First Name</label>
						<div class="cols-sm-10">
							<input type="text" class="form-control" name="firstName"
								id="lastName" placeholder="Enter your Name"
								value="${user.firstName}" required />
						</div>
					</div>

					<div class="form-group">
						<label for="name" class="cols-sm-2 control-label">Your
							Last Name</label>
						<div class="cols-sm-10">
							<input type="text" class="form-control" name="lastName"
								id="lastName" placeholder="Enter your Name"
								value="${user.lastName}" required />
						</div>
					</div>

					<div class="form-group">
						<label for="email" class="cols-sm-2 control-label">Your
							Email</label>
						<div class="cols-sm-10">
							<input type="text" class="form-control" name="email" id="email"
								placeholder="Enter your Email" value="${user.email}" required />
						</div>
					</div>

					<div class="form-group">
						<label for="username" class="cols-sm-2 control-label">Phone
							Number</label>
						<div class="cols-sm-10">
							<input type="number" max="9999999999" min="1000000000"
								class="form-control" name="phoneNumber" id="phoneNumber"
								placeholder="Enter your Phone Number"
								value="${user.phoneNumber}" required />
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<div class="form-group ">
						<button class="btn btn-primary" type="submit">Edit</button>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>