<html>
<%@ include file="../header.jsp"%>
</head>
<body>
<body>
	<div class="container">
		<div class="row main">
			<div class="main-login main-center">
				<h3>Create Your First Course</h3>
				<br>
				<form class="" method="POST" action="create-course">
					<div id="form-group">
						<label>Course Name </label><input class="form-control" type="text"
							name="name" required />
					</div>
					<br>
					<div id="form-group">
						<label>Course Description </label>
						<textarea class="form-control" name="description" rows="4"
							cols="50">Short Description (Not Requred)</textarea>
					</div>
					<br>
					<div class="form-group">
						<button class="btn btn-primary" type="submit">Create</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>