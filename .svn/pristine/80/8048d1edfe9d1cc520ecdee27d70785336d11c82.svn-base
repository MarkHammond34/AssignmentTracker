<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="navbar-wrapper">
	<div class="container-fluid">
		<nav class="navbar navbar-fixed-top">
			<div class="container">
				<div class="navbar-header"></div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="home" class="">Home</a></li>
						<li class=" dropdown"><a href="#" class="dropdown-toggle "
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">Courses <span class="caret"></span></a>
							<ul class="dropdown-menu">

								<c:forEach var="course" items="${courses}">
									<li class=" dropdown"><a href="#" class="dropdown-toggle "
										data-toggle="dropdown" role="button" aria-haspopup="true"
										aria-expanded="false">${course.name}</a></li>
								</c:forEach>

							</ul></li>
						<li class=""><a href="#" data-toggle="modal"
							data-target="#createCourseModal">Create New Course</a></li>
						<li class=" dropdown"><a href="#" class="dropdown-toggle "
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">Assignments<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="home">Today's Assignments</a></li>
								<li><a href="weekly-assignments">This Week's
										Assignments</a></li>
							</ul></li>
						<li class=""><a href="#" data-toggle="modal"
							data-target="#createAssignmentModal">Create New Assignment</a></li>
					</ul>

					<ul class="nav navbar-nav pull-right">
						<c:if test="${empty user}">
							<li class=""><a href="login" class="">Login</a></li>
							<li class=""><a href="register" class="">Register</a></li>
						</c:if>

						<c:if test="${!empty user}">
							<li class=" dropdown"><a href="#"
								class="dropdown-toggle active" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">Hi,
									${ user.firstName}!<span class="caret"></span>
							</a>
								<ul class="dropdown-menu">
									<li><a href="account">Account</a></li>
									<li><a href="logout">Logout</a></li>
								</ul></li>
						</c:if>
					</ul>
				</div>
			</div>
		</nav>
	</div>
</div>
<br>