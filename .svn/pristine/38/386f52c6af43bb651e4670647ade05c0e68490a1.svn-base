<c:if test="${assignment.priority eq 3}">
	<div class="panel panel-success">
		<div class="panel-heading">
			<c:if test="${now >= assignment.due}">
				<h4 style="text-align: right; color: red;">
					Due at ${assignment.due} <i
						class="glyphicon glyphicon-exclamation-sign"></i>
				</h4>
			</c:if>
			<c:if test="${now < assignment.due}">
				<h4 style="text-align: right;">Due at ${assignment.due}</h4>
			</c:if>
			<h1>${assignment.name}</h1>
			<div class="option-btns">
				<a data-toggle="collapse"
					href="#collapse3${assignment.assignmentID}"
					class="btn btn-primary btn-circle btn-lg"> <i
					class="glyphicon glyphicon-resize-full"></i></a> <a
					href="mark-as-done?id=${assignment.assignmentID}"
					class="btn btn-info btn-circle btn-lg" title="Done"> <i
					class="glyphicon glyphicon-ok"></i>
				</a>
			</div>
			<div class="row"></div>
		</div>
		<div id="collapse3${assignment.assignmentID}"
			class="panel-collapse collapse">
			<div class="panel-body">
				<a href="#" class="course-link">${assignment.courseName}</a>
				<p>${assignment.description}</p>

				<!-- Reminder Info -->
				<c:if test="${assignment.reminder != null}">
					<h2>Reminder To Be Sent At: ${assignment.reminder.timestamp}</h2>
					<i class="glyphicon glyphicon-bell"></i>
					<c:if test="${assignment.type eq 200}">
						<h4>To: ${user.email}</h4>
					</c:if>
				</c:if>
			</div>
		</div>
	</div>
</c:if>
<c:if test="${assignment.priority eq 2}">
	<div class="panel panel-warning">
		<div class="panel-heading">
			<c:if test="${now >= assignment.due}">
				<h4 style="text-align: right; color: red;">
					Due at ${assignment.due} <i
						class="glyphicon glyphicon-exclamation-sign"></i>
				</h4>
			</c:if>
			<c:if test="${now < assignment.due}">
				<h4 style="text-align: right;">Due at ${assignment.due}</h4>
			</c:if>
			<h1>${assignment.name}</h1>
			<div class="option-btns">
				<a data-toggle="collapse"
					href="#collapse2${assignment.assignmentID}"
					class="btn btn-primary btn-circle btn-lg"> <i
					class="glyphicon glyphicon-resize-full"></i></a> <a
					href="mark-as-done?id=${assignment.assignmentID}"
					class="btn btn-info btn-circle btn-lg" title="Done"> <i
					class="glyphicon glyphicon-ok"></i>
				</a>
			</div>
		</div>
		<div id="collapse2${assignment.assignmentID}"
			class="panel-collapse collapse">
			<div class="panel-body">
				<a href="#" class="course-link">${assignment.courseName}</a>
				<p>${assignment.description}</p>

				<!-- Reminder Info -->
				<c:if test="${assignment.reminder != null}">
					<h2>Reminder To Be Sent At: ${assignment.reminder.timestamp}</h2>
					<i class="glyphicon glyphicon-bell"></i>
					<c:if test="${assignment.type eq 200}">
						<h4>To: ${user.email}</h4>
					</c:if>
				</c:if>
			</div>
		</div>
	</div>
</c:if>
<c:if test="${assignment.priority eq 1}">
	<div class="panel panel-danger">
		<div class="panel-heading">
			<c:if test="${now >= assignment.due}">
				<h4 style="text-align: right; color: red;">
					Due at ${assignment.due} <i
						class="glyphicon glyphicon-exclamation-sign"></i>
				</h4>
			</c:if>
			<c:if test="${now < assignment.due}">
				<h4 style="text-align: right;">Due at ${assignment.due}</h4>
			</c:if>
			<a href="#" class="course-link">${assignment.courseName}</a>
			<h1>${assignment.name}</h1>
			<div class="option-btns">
				<a data-toggle="collapse"
					href="#collapse1${assignment.assignmentID}"
					class="btn btn-primary btn-circle btn-lg"> <i
					class="glyphicon glyphicon-resize-full"></i></a> <a
					href="mark-as-done?id=${assignment.assignmentID}"
					class="btn btn-info btn-circle btn-lg" title="Done"> <i
					class="glyphicon glyphicon-ok"></i>
				</a>
			</div>
			<div class="row"></div>
		</div>
		<div id="collapse1${assignment.assignmentID}"
			class="panel-collapse collapse">
			<div class="panel-body">
				<h5>Assignment Description</h5>
				<p>${assignment.description}</p>

				<!-- Reminder Info -->
				<c:if test="${assignment.reminder != null}">
					<h2>Reminder To Be Sent At: ${assignment.reminder.timestamp}</h2>
					<i class="glyphicon glyphicon-bell"></i>
					<c:if test="${assignment.type eq 200}">
						<h4>To: ${user.email}</h4>
					</c:if>
				</c:if>
			</div>
		</div>
	</div>
</c:if>