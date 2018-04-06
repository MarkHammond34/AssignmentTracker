<jsp:useBean id="now" class="java.util.Date" />
<c:if test="${!empty assignments}">
	<c:forEach var="assignment" items="${assignments}">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<%@ include file="assignment.jsp"%>
			</div>
			<div class="col-md-1"></div>
		</div>
	</c:forEach>
</c:if>

<c:if test="${empty assignments}">
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10 assignment-green">
			<h3>No Assignments Today!</h3>
		</div>
		<div class="col-md-1"></div>
	</div>
</c:if>