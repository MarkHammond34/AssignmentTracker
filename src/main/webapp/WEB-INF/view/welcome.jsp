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
				<h1>Welcome! Login or Register To Get Started!</h1>
			</div>
			<div class="col-md-2"></div>
		</div>

		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-5 panel" style="margin: 5px;">
				<h3>Login</h3>
				<form class="" method="POST" action="login">
					<div class="form-group">
						<label for="name" class="cols-sm-2 control-label">Email</label>
						<div class="cols-sm-10">
							<input type="text" class="form-control" name="email" id="email"
								placeholder="Enter your Name" required />
						</div>
					</div>

					<div class="form-group">
						<label for="password" class="cols-sm-2 control-label">Password</label>
						<div class="cols-sm-10">
							<input type="password" class="form-control" name="password"
								id="password" placeholder="Enter your Password" required />
						</div>
					</div>

					<div class="form-group ">
						<button class="btn btn-primary" type="submit">Login</button>
					</div>
				</form>
			</div>
			<div class="col-md-5 panel" style="margin: 5px;">
				<h3>Register</h3>
				<form class="" method="POST" action="register">
					<div class="form-group">
						<label for="name" class="cols-sm-2 control-label">Your
							First Name</label>
						<div class="cols-sm-10">
							<input type="text" class="form-control" name="firstName"
								id="lastName" placeholder="Enter your Name" required />
						</div>
					</div>

					<div class="form-group">
						<label for="name" class="cols-sm-2 control-label">Your
							Last Name</label>
						<div class="cols-sm-10">
							<input type="text" class="form-control" name="lastName"
								id="lastName" placeholder="Enter your Name" required />
						</div>
					</div>

					<div class="form-group">
						<label for="email" class="cols-sm-2 control-label">Your
							Email</label>
						<div class="cols-sm-10">
							<input type="text" class="form-control" name="email" id="email"
								placeholder="Enter your Email" required />
						</div>
					</div>

					<div class="form-group">
						<label for="username" class="cols-sm-2 control-label">Phone
							Number</label>
						<div class="cols-sm-10">
							<input type="number" max="9999999999" min="1000000000"
								class="form-control" name="phoneNumber" id="phoneNumber"
								placeholder="Enter your Phone Number" required />
						</div>
					</div>

					<div class="form-group">
						<label for="password" class="cols-sm-2 control-label">Password</label>
						<div class="cols-sm-10">
							<input type="password" class="form-control" name="password"
								id="password" placeholder="Enter your Password" required />
						</div>
					</div>

					<div class="form-group">
						<label for="confirm" class="cols-sm-2 control-label">Confirm
							Password</label>
						<div class="cols-sm-10">
							<input type="password" class="form-control" name="confirm"
								id="confirm" placeholder="Confirm your Password" required />
						</div>
					</div>

					<div class="form-group ">
						<button class="btn btn-primary" type="submit">Register</button>
					</div>
				</form>
			</div>
			<div class="col-md-1"></div>
		</div>

	</div>

	<%@ include file="assignment/create-assignment-modal.jsp"%>
	<%@ include file="course/create-course-modal.jsp"%>

	<script src="resources/js/assignment.js"></script>
</body>
</html>