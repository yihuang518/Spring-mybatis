<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Management</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="<s:url value="/resources/css/home.css" />"
	type="text/css">
<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				$("#request-link").click(
						function(e) {
							e.preventDefault();
							$.post("/ninyan/resource/request", $("form")
									.serialize(), function(data) {
								alert(data);
							});
							return false;
						});
			});
</script>
</head>
<body>
	<jsp:include page="../views/fragments/header.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<s:url value="/resource/save" var="formUrl" />
			<f:form action="${formUrl}" method="post" modelAttribute="resource"
				class="col-md-8 col-md-offset-2">

				<div class="form-group">
					<label for="resource-name">Name</label>
					<f:input id="resource-name" cssClass="form-control" path="name" />
				</div>
				<div class="form-group">
					<label for="date">Date</label>
					<f:input id="date" cssClass="form-control" path="date" />
				</div>
				<div class="form-group">
					<label for="resource-type">Resource Type</label>
					<f:select path="type" items="${ typeOptions }"
						cssClass="selectpicker" id="resource-type" />
				</div>
				<div class="form-group">
					<label for="unit">Unit of Measures</label>
					<f:radiobuttons path="unitOfMeasure" items="${ radioOptions }"
						id="unit" />
				</div>
				<div class="form-group">
					<label for="indicators">Resource Type</label>
					<f:checkboxes path="indicators" items="${ checkOptions }"
						id="indicators" />
					<a id="request-link" href="<s:url value="/resource/request" />">Send
						Request</a>
				</div>

				<div class="form-group">
					<label for="notes">Notes</label>
					<f:textarea path="notes" id="notes" class="form-control" rows="3" />
				</div>

				<button type="submit" class="btn btn-default">Submit</button>
			</f:form>
			<s:url value="/resource/upload" var="uploadUrl" />
			<form method="POST" enctype="multipart/form-data" action="${uploadUrl}"> File to upload: <input type="file" name="file"> <br />
			<input type="submit" value="Upload" />
			</form>
		</div>
	</div>
</body>
</html>